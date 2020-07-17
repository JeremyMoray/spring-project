package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.model.TranslationProduct;

import java.util.List;

public interface ProductDataAccess {
    List<TranslationProduct> findAllByLocaleByCategory(String locale, String product);
    TranslationProduct findProductByLocale(String locale, String product);
}
