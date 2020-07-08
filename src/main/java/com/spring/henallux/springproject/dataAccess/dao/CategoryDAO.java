package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.springproject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springproject.model.Category;
import com.spring.henallux.springproject.model.TranslationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess{

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    public List<TranslationCategory> findAllByLocale(String locale){
        List<TranslationCategoryEntity> translationCategoryEntities = categoryRepository.findAllByLocale(locale);
        List<TranslationCategory> translationCategories = new ArrayList();;
        for (TranslationCategoryEntity translationCategoryEntity:translationCategoryEntities) {
            translationCategories.add(providerConverter.categoryEntityToCategoryModel(translationCategoryEntity));
        }
        return translationCategories;
    }
}
