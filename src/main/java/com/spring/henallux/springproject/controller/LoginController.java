package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        UserDetails user = new User();
        model.addAttribute("userForm", user);
        model.addAttribute("currentPage", "login");
        model.addAttribute("title", "Login");
        return "integrated:login";
    }
}
