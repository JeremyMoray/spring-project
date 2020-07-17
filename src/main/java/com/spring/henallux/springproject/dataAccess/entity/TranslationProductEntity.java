package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation_product")
@IdClass(TranslationProductEntityId.class)
public class TranslationProductEntity {

    public TranslationProductEntity(){

    }

    @Id
    @Column(name="product_id")
    private Integer productId;

    @Id
    @Column(name="language_id")
    private Integer languageId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @JoinColumn(name="product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private ProductEntity product;

    @JoinColumn(name="language_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private LanguageEntity language;

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
