package com.spring.henallux.springproject.model;

import java.io.Serializable;

public class TranslationCategory implements Serializable {

    private String name;

    private Category category;

    private Language language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}