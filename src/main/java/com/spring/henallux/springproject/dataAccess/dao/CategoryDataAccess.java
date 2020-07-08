package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.TranslationCategory;

import java.util.List;

public interface CategoryDataAccess {
    public List<TranslationCategory> findAllByLocale(String locale);
}
