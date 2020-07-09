package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.TranslationProduct;

import java.util.List;

public interface ProductDataAccess {
    public List<TranslationProduct> findAllByLocaleByCategory(String locale, String product);
    public TranslationProduct findProductByLocale(String locale, String product);
}
