package com.spring.henallux.springproject.model;

import java.io.Serializable;

public class TranslationProduct implements Serializable {

    private String name;

    private Product product;

    private Language language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
