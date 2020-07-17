package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.ProductDAO;
import com.spring.henallux.springproject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.springproject.model.TranslationProduct;
import com.spring.henallux.springproject.service.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@SessionAttributes({Constant.BASKET})
@RequestMapping(value="/basket")
public class BasketController {

    private ProductDataAccess productDataAccess;
    private final MessageSource messageSource;

    @ModelAttribute(Constant.BASKET)
    public HashMap<String, Integer> basket(){
        HashMap<String, Integer> basket = new HashMap<>();
        return basket;
    }

    @Autowired
    public BasketController(ProductDAO productDataAccess, MessageSource messageSource){
        this.messageSource = messageSource;
        this.productDataAccess = productDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        model.addAttribute(basket);
        model.addAttribute("currentPage", "basket");
        model.addAttribute("title", messageSource.getMessage("basket", null, LocaleContextHolder.getLocale()));

        HashMap<TranslationProduct, Integer> translationProducts = new HashMap<>();

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            translationProducts.put(productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), entry.getKey()), entry.getValue());
        }

        model.addAttribute("translationProducts", translationProducts);

        return "integrated:basket";
    }

    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String updateProduct(@ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket, @RequestParam String keyname, @RequestParam Integer quantity){
        basket.put(keyname, quantity);

        return "redirect:/basket";
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String deleteProduct(@ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket, @RequestParam String keyname){
        basket.remove(keyname);

        return "redirect:/basket";
    }

    @RequestMapping(value="/deleteAll", method = RequestMethod.GET)
    public String deleteAllProduct(@ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        basket.clear();

        return "redirect:/home";
    }
}
