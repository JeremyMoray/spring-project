package com.spring.henallux.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/about")
public class AboutController {

    private final MessageSource messageSource;

    @Autowired
    public AboutController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String about(Model model){
        model.addAttribute("currentPage", "about");
        model.addAttribute("title", messageSource.getMessage("about", null, LocaleContextHolder.getLocale()));
        return "integrated:about";
    }
}