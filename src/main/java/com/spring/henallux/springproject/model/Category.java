package com.spring.henallux.springproject.model;

import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;

import java.util.List;

public class Category {

    private Integer id;

    private String keyname;

    private List<TranslationCategoryEntity> translationCategories;

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

    public List<TranslationCategoryEntity> getTranslationCategories() {
        return translationCategories;
    }

    public void setTranslationCategories(List<TranslationCategoryEntity> translationCategories) {
        this.translationCategories = translationCategories;
    }
}
