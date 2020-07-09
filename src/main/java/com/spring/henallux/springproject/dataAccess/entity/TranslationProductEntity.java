package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="translation_product")
@IdClass(TranslationProductEntity.class)
public class TranslationProductEntity implements Serializable {

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Id
    @JoinColumn(name="product_id", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    @Id
    @JoinColumn(name="language_id", referencedColumnName = "id")
    @ManyToOne
    private LanguageEntity language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
