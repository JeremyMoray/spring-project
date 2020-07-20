package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.ProductDAO;
import com.spring.henallux.springproject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.springproject.model.TranslationProduct;
import com.spring.henallux.springproject.service.Constant;
import com.spring.henallux.springproject.service.DiscountService;
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
    private DiscountService discountService;
    private final MessageSource messageSource;

    @ModelAttribute(Constant.BASKET)
    public HashMap<String, Integer> basket(){
        HashMap<String, Integer> basket = new HashMap<>();
        return basket;
    }

    @Autowired
    public BasketController(ProductDAO productDataAccess, MessageSource messageSource, DiscountService discountService){
        this.messageSource = messageSource;
        this.productDataAccess = productDataAccess;
        this.discountService = discountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String basket(Model model, @ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket){
        model.addAttribute(basket);
        model.addAttribute("currentPage", "basket");
        model.addAttribute("title", messageSource.getMessage("basket", null, LocaleContextHolder.getLocale()));

        HashMap<TranslationProduct, Integer> translationProducts = new HashMap<>();

        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            TranslationProduct translationProduct = productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), entry.getKey());
            translationProduct.getProduct().setUnitPrice(discountService.calculateRealPrice(translationProduct.getProduct().getUnitPrice(), translationProduct.getProduct().getDiscountPercentage()));
            translationProducts.put(translationProduct, entry.getValue());
        }

        model.addAttribute("translationProducts", translationProducts);

        return "integrated:basket";
    }

    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String updateProduct(@ModelAttribute(value=Constant.BASKET) HashMap<String, Integer> basket, @RequestParam String keyname, @RequestParam Integer quantity){
        if(quantity > 0){
            basket.put(keyname, quantity);

            return "redirect:/basket";
        }
        return "error:integrated";
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
