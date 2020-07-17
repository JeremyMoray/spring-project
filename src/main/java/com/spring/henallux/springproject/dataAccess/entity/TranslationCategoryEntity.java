package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="translation_category")
@IdClass(TranslationCategoryEntity.class)
public class TranslationCategoryEntity implements Serializable {

    public TranslationCategoryEntity(){

    }

    @Column(name="name")
    private String name;

    @Id
    @JoinColumn(name="category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

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
