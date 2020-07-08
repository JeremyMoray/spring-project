package com.spring.henallux.springproject.model;

import com.spring.henallux.springproject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springproject.dataAccess.entity.LanguageEntity;

import java.io.Serializable;

public class TranslationCategory implements Serializable {

    private String name;

    private CategoryEntity category;

    private LanguageEntity language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}