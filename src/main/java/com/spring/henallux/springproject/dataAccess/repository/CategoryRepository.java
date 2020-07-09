package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<TranslationCategoryEntity, Integer> {

    @Query("select translationCategory " +
            "from CategoryEntity category, TranslationCategoryEntity translationCategory, LanguageEntity language " +
            "where category = translationCategory.category " +
            "and translationCategory.language = language " +
            "and language.locale = ?1"
    )
    public List<TranslationCategoryEntity> findAllByLocale(String locale);
}