package com.spring.henallux.springproject.model;

import java.util.List;

public class Category{

    private Integer id;

    private String keyname;

    private List<TranslationCategory> translationCategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public List<TranslationCategory> getTranslationCategories() {
        return translationCategories;
    }

    public void setTranslationCategories(List<TranslationCategory> translationCategories) {
        this.translationCategories = translationCategories;
    }
}
