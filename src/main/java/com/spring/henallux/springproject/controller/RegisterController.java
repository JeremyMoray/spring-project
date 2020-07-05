package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.UserDAO;
import com.spring.henallux.springproject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

    private UserDataAccess userDataAccess;

    @Autowired
    public RegisterController(UserDAO userDataAccess){
        this.userDataAccess = userDataAccess;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        UserDetails user = new User();
        model.addAttribute("userForm", user);
        model.addAttribute("currentPage", "register");
        model.addAttribute("title", "Register");
        return "integrated:register";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value="userForm") User user, final BindingResult errors){

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        if(!errors.hasErrors()){
            userDataAccess.save(user);
            return "redirect:/home";
        }
        return "integrated:register";
    }
}
