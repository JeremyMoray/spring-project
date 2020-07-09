package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.springproject.dataAccess.entity.TranslationProductEntity;
import com.spring.henallux.springproject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.springproject.dataAccess.repository.ProductRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springproject.model.TranslationCategory;
import com.spring.henallux.springproject.model.TranslationProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO  implements ProductDataAccess {

    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    public List<TranslationProduct> findAllByLocaleByCategory(String locale, String category){
        List<TranslationProductEntity> translationProductEntities = productRepository.findAllByLocaleByCategory(locale, category);
        List<TranslationProduct> translationProducts = new ArrayList();;
        for (TranslationProductEntity translationProductEntity:translationProductEntities) {
            translationProducts.add(providerConverter.productEntityToProductModel(translationProductEntity));
        }
        return translationProducts;
    }
}
