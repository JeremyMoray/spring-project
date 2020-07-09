package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="category")
public class CategoryEntity {

    public CategoryEntity(){

    }

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="keyname")
    private String keyname;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
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
