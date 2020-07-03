package com.spring.henallux.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/products")
public class ProductsController {

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("currentPage", "products");
        model.addAttribute("title", "Products");
        return "integrated:products";
    }
}
