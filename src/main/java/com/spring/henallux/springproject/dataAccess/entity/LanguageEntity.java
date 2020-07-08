package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="language")
public class LanguageEntity {

    public LanguageEntity(){

    }

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="locale")
    private String locale;

    @OneToMany(mappedBy = "language")
    private List<TranslationCategoryEntity> translationCategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<TranslationCategoryEntity> getTranslationCategories() {
        return translationCategories;
    }

    public void setTranslationCategories(List<TranslationCategoryEntity> translationCategories) {
        this.translationCategories = translationCategories;
    }
}
