package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.Command;
import com.spring.henallux.springproject.model.User;

import java.util.Date;

public interface CommandDataAccess {

    Command save(Command command);
    Command findByDateAndUser(Date date, User user);
}
