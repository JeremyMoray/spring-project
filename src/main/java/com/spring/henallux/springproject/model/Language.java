package com.spring.henallux.springproject.model;

import java.util.List;

public class Language{

    private Integer id;

    private String name;

    private String locale;

    private List<TranslationCategory> translationCategories;

    private List<TranslationProduct> translationProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<TranslationCategory> getTranslationCategories() {
        return translationCategories;
    }

    public void setTranslationCategories(List<TranslationCategory> translationCategories) {
        this.translationCategories = translationCategories;
    }

    public List<TranslationProduct> getTranslationProducts() {
        return translationProducts;
    }

    public void setTranslationProducts(List<TranslationProduct> translationProducts) {
        this.translationProducts = translationProducts;
    }
}
