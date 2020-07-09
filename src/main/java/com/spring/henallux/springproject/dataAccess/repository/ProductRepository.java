package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.TranslationProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<TranslationProductEntity, Integer> {

    @Query("select translationProduct " +
            "from ProductEntity product, TranslationProductEntity translationProduct, LanguageEntity language, CategoryEntity category " +
            "where product = translationProduct.product " +
            "and translationProduct.language = language " +
            "and language.locale = ?1 " +
            "and product.category = category " +
            "and category.keyname = ?2 "
    )
    public List<TranslationProductEntity> findAllByLocaleByCategory(String locale, String category);
}
