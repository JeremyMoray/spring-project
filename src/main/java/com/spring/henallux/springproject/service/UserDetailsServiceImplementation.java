package com.spring.henallux.springproject.service;

import com.spring.henallux.springproject.dataAccess.dao.UserDAO;
import com.spring.henallux.springproject.dataAccess.dao.UserDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserDataAccess userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userDAO.findByUsername(username);
        if(userDetails != null){
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
