package com.spring.henallux.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class WelcomeController {

    private final MessageSource messageSource;

    @Autowired
    public WelcomeController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("currentPage", "home");
        model.addAttribute("title", messageSource.getMessage("home", null, LocaleContextHolder.getLocale()));
        return "integrated:welcome";
    }
}
