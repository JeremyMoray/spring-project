package com.spring.henallux.springproject.controller;

import com.spring.henallux.springproject.dataAccess.dao.UserDAO;
import com.spring.henallux.springproject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

    private UserDataAccess userDataAccess;
    private final MessageSource messageSource;

    @Autowired
    public RegisterController(UserDAO userDataAccess, MessageSource messageSource){
        this.userDataAccess = userDataAccess;
        this.messageSource = messageSource;
    }

    //Method that set empty fields to null because Size does not allow empty values
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        UserDetails user = new User();
        model.addAttribute("userForm", user);
        model.addAttribute("currentPage", "register");
        model.addAttribute("title", messageSource.getMessage("register", null, LocaleContextHolder.getLocale()));
        return "integrated:register";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute(value="userForm") User user, final BindingResult errors){

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        if(user.getPassword() != null && !user.getPassword().isEmpty()){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
        }
        else{
            user.setPassword(null);
        }

        if(errors.hasErrors()){
            user.setPassword(null);
            model.addAttribute("currentPage", "register");
            model.addAttribute("title", "Register");
            return "integrated:register";
        }

        if(userDataAccess.existsByEmail(user.getEmail())){
            user.setPassword(null);
            model.addAttribute("currentPage", "register");
            model.addAttribute("title", "Register");
            model.addAttribute("existingEmailError", true);
            return "integrated:register";
        }

        if(userDataAccess.existsById(user.getUsername())){
            user.setPassword(null);
            model.addAttribute("currentPage", "register");
            model.addAttribute("title", "Register");
            model.addAttribute("existingUserError", true);
            return "integrated:register";
        }

        userDataAccess.save(user);
        return "redirect:/home";
    }
}
