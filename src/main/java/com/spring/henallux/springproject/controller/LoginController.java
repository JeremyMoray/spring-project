package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    private final MessageSource messageSource;

    @Autowired
    public LoginController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String login(Model model){
        UserDetails user = new User();
        model.addAttribute("userForm", user);
        model.addAttribute("currentPage", "login");
        model.addAttribute("title", messageSource.getMessage("login", null, LocaleContextHolder.getLocale()));
        return "integrated:login";
    }
}
