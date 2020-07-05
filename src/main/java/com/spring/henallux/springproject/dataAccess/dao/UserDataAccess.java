package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.User;

public interface UserDataAccess {

    public User findByUsername(String username);
    public User save(User user);
}
