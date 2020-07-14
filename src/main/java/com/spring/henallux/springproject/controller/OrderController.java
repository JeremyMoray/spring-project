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
@RequestMapping(value="/order")
public class OrderController {

    private ProductDataAccess productDataAccess;
    private final MessageSource messageSource;

    @Autowired
    public OrderController(ProductDAO productDataAccess, MessageSource messageSource){
        this.messageSource = messageSource;
        this.productDataAccess = productDataAccess;
    }

    @RequestMapping(value="/payment", method = RequestMethod.GET)
    public String pay(Model model, @ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        model.addAttribute(basket);
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
