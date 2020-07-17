package com.spring.henallux.springproject.dataAccess.entity;

import java.io.Serializable;

public class TranslationCategoryEntityId implements Serializable {

    private Integer categoryId;

    private Integer languageId;

    public TranslationCategoryEntityId(){

    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
}
