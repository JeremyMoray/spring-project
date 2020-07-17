package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation_category")
@IdClass(TranslationCategoryEntityId.class)
public class TranslationCategoryEntity {

    public TranslationCategoryEntity(){

    }

    @Id
    @Column(name="category_id")
    private Integer categoryId;

    @Id
    @Column(name="language_id")
    private Integer languageId;

    @Column(name="name")
    private String name;

    @JoinColumn(name="category_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name="language_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private LanguageEntity language;

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
