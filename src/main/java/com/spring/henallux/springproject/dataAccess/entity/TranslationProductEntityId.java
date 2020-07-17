package com.spring.henallux.springproject.dataAccess.entity;

import java.io.Serializable;

public class TranslationProductEntityId implements Serializable {

    private Integer productId;

    private Integer languageId;

    public TranslationProductEntityId(){

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
}
