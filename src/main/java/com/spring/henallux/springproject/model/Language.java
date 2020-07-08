package com.spring.henallux.springproject.model;

import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;

import java.util.List;

public class Language {

    private Integer id;

    private String name;

    private String locale;

    private List<TranslationCategoryEntity> translationCategories;

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

    public List<TranslationCategoryEntity> getTranslationCategories() {
        return translationCategories;
    }

    public void setTranslationCategories(List<TranslationCategoryEntity> translationCategories) {
        this.translationCategories = translationCategories;
    }
}
