package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.springproject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.springproject.dataAccess.dao.ProductDAO;
import com.spring.henallux.springproject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.springproject.model.Category;
import com.spring.henallux.springproject.model.TranslationCategory;
import com.spring.henallux.springproject.model.TranslationProduct;
import com.spring.henallux.springproject.service.Constant;
import com.spring.henallux.springproject.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes({Constant.BASKET})
@RequestMapping(value="/catalog")
public class CatalogController {

    private CategoryDataAccess categoryDataAccess;
    private ProductDataAccess productDataAccess;
    private DiscountService discountService;
    private final MessageSource messageSource;

    @ModelAttribute(Constant.BASKET)
    public HashMap<String, Integer> basket(){
        HashMap<String, Integer> basket = new HashMap<>();
        return basket;
    }

    @Autowired
    public CatalogController(CategoryDAO categoryDataAccess, ProductDAO productDataAccess, DiscountService discountService, MessageSource messageSource){
        this.messageSource = messageSource;
        this.categoryDataAccess = categoryDataAccess;
        this.productDataAccess = productDataAccess;
        this.discountService = discountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCatalog(Model model){
        model.addAttribute("currentPage", "catalog");
        model.addAttribute("title", messageSource.getMessage("catalog", null, LocaleContextHolder.getLocale()));
        model.addAttribute("translationCategories", categoryDataAccess.findAllByLocale(LocaleContextHolder.getLocale().toString()));
        return "integrated:catalog";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String getCategory(Model model, @PathVariable("category") String category){
        model.addAttribute("currentPage", "catalog");
        model.addAttribute("title", messageSource.getMessage("catalog", null, LocaleContextHolder.getLocale()));

        TranslationCategory chosenCategory = categoryDataAccess.findByKeynameByLocale(category, LocaleContextHolder.getLocale().toString());
        if(chosenCategory == null)
            return "redirect:/catalog";

        List<TranslationProduct> translationProducts = productDataAccess.findAllByLocaleByCategory(LocaleContextHolder.getLocale().toString(), category);

        List<Double> realPrices = new ArrayList<>();
        for(int i = 0; i < translationProducts.size(); i++){
            realPrices.add(discountService.calculateRealPrice(translationProducts.get(i).getProduct().getUnitPrice(), translationProducts.get(i).getProduct().getDiscountPercentage()));
        }

        model.addAttribute("categoryName", chosenCategory.getName());
        model.addAttribute("translationProducts", translationProducts);
        model.addAttribute("realPrices", realPrices);
        return "integrated:products";
    }

    @RequestMapping(value = "/{category}/{product}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable("category") String category, @PathVariable("product") String product){

        TranslationCategory chosenCategory = categoryDataAccess.findByKeynameByLocale(category, LocaleContextHolder.getLocale().toString());
        if(chosenCategory == null)
            return "redirect:/catalog";
        model.addAttribute("category", chosenCategory);

        TranslationProduct chosenProduct = productDataAccess.findProductByLocale(LocaleContextHolder.getLocale().toString(), product);
        if(chosenProduct == null)
            return "redirect:/catalog/{category}";
        model.addAttribute("translationProduct", chosenProduct);

        if(chosenProduct.getProduct().getDiscountPercentage() != null && chosenProduct.getProduct().getDiscountPercentage() != 0){
            Double discountPrice = discountService.calculateRealPrice(chosenProduct.getProduct().getUnitPrice(), chosenProduct.getProduct().getDiscountPercentage());
            model.addAttribute("discountPrice", discountPrice);
        }

        model.addAttribute("currentPage", "catalog");
        model.addAttribute("title", chosenProduct.getName());
        return "integrated:details";
    }

    @RequestMapping(value = "/{category}/{product}/add/{quantity}", method = RequestMethod.GET)
    public String addQuantity(@PathVariable("category") String category,
                       @PathVariable("product") String product,
                       @PathVariable("quantity") Integer quantity,
                       HttpSession session
    ){
        if(quantity > 0){
            HashMap<String, Integer> basket = (HashMap<String, Integer>) session.getAttribute(Constant.BASKET);
            if(basket.containsKey(product)){
                basket.put(product, basket.get(product) + quantity);
            }
            else{
                basket.put(product, quantity);
            }
            session.setAttribute(Constant.BASKET, basket);

            return "redirect:/catalog/" + category;
        }
        return "integrated:error";
    }
}
