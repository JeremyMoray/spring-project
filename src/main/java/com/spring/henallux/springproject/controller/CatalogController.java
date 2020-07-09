package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.springproject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.springproject.dataAccess.dao.ProductDAO;
import com.spring.henallux.springproject.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {

    private CategoryDataAccess categoryDataAccess;
    private ProductDataAccess productDataAccess;
    private final MessageSource messageSource;

    @Autowired
    public CatalogController(CategoryDAO categoryDataAccess, ProductDAO productDataAccess, MessageSource messageSource){
        this.messageSource = messageSource;
        this.categoryDataAccess = categoryDataAccess;
        this.productDataAccess = productDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("currentPage", "catalog");
        model.addAttribute("title", messageSource.getMessage("catalog", null, LocaleContextHolder.getLocale()));
        model.addAttribute("translationCategories", categoryDataAccess.findAllByLocale(LocaleContextHolder.getLocale().toString()));
        return "integrated:catalog";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String home(Model model, @PathVariable("category") String category){
        model.addAttribute("currentPage", "catalog");
        model.addAttribute("title", messageSource.getMessage("catalog", null, LocaleContextHolder.getLocale()));
        model.addAttribute("translationProducts", productDataAccess.findAllByLocaleByCategory(LocaleContextHolder.getLocale().toString(), category));
        return "integrated:products";
    }
}
