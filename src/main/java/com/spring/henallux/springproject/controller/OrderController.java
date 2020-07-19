package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.*;
import com.spring.henallux.springproject.model.*;
import com.spring.henallux.springproject.service.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@Controller
@SessionAttributes({Constant.BASKET})
@RequestMapping(value="/order")
public class OrderController {

    private ProductDataAccess productDataAccess;
    private CommandDataAccess commandDataAccess;
    private CommandLineDataAccess commandLineDataAccess;
    private final MessageSource messageSource;

    @ModelAttribute(Constant.BASKET)
    public HashMap<String, Integer> basket(){
        HashMap<String, Integer> basket = new HashMap<>();
        return basket;
    }

    @Autowired
    public OrderController(ProductDAO productDataAccess, CommandDAO commandDataAccess, CommandLineDAO commandLineDataAccess, MessageSource messageSource){
        this.messageSource = messageSource;
        this.productDataAccess = productDataAccess;
        this.commandDataAccess = commandDataAccess;
        this.commandLineDataAccess = commandLineDataAccess;
    }

    @RequestMapping(value="/confirmation", method = RequestMethod.GET)
    public String confirmation(Model model, @ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        model.addAttribute("currentPage", null);
        model.addAttribute("title", messageSource.getMessage("confirmation", null, LocaleContextHolder.getLocale()));

        HashMap<TranslationProduct, Integer> translationProducts = new HashMap<>();

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            TranslationProduct translationProduct = productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), entry.getKey());
            translationProducts.put(translationProduct, entry.getValue());
        }

        model.addAttribute("translationProducts", translationProducts);

        return "integrated:confirmation";
    }

    @RequestMapping(value="/validation", method = RequestMethod.GET)
    public String validation(@ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket, Authentication authentication){

        Date date = new Date();
        User user = (User) authentication.getPrincipal();
        Command command = new Command();

        command.setDate(date);
        command.setUser(user);

        commandDataAccess.save(command);

        command = commandDataAccess.findByDateAndUser(date, user);

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            CommandLine commandLine = new CommandLine();

            commandLine.setCommandId(command.getId());
            commandLine.setCommand(command);

            Product product = productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), entry.getKey()).getProduct();
            commandLine.setProductId(product.getId());
            commandLine.setProduct(product);

            commandLine.setQuantity(entry.getValue());

            commandLineDataAccess.save(commandLine);
        }

        return "redirect:/order/payment";
    }

    @RequestMapping(value="/payment", method = RequestMethod.GET)
    public String pay(Model model, @ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        model.addAttribute("currentPage", null);
        model.addAttribute("title", messageSource.getMessage("order", null, LocaleContextHolder.getLocale()));

        HashMap<TranslationProduct, Integer> translationProducts = new HashMap<>();
        double totalPrice = 0;

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            TranslationProduct translationProduct = productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), entry.getKey());
            totalPrice += translationProduct.getProduct().getUnitPrice() * entry.getValue();
            translationProducts.put(translationProduct, entry.getValue());
        }

        model.addAttribute("translationProducts", translationProducts);
        model.addAttribute("totalPrice", totalPrice);

        return "integrated:payment";
    }
}
