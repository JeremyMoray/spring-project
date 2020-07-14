package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.Command;
import com.spring.henallux.springproject.model.User;

import java.util.Date;

public interface CommandDataAccess {

    public Command save(Command command);
    public Command findByDateAndUser(Date date, User user);
}
