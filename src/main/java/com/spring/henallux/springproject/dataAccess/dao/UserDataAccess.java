package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.User;

public interface UserDataAccess {

    User findByUsername(String username);
    User save(User user);
}
