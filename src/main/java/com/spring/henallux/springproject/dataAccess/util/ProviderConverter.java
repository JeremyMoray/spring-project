package com.spring.henallux.springproject.dataAccess.util;

import com.spring.henallux.springproject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.springproject.dataAccess.entity.TranslationProductEntity;
import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import com.spring.henallux.springproject.model.TranslationCategory;
import com.spring.henallux.springproject.model.TranslationProduct;
import com.spring.henallux.springproject.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();
    public UserEntity userModelToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setAuthorities(user.getStringAuthorities());
        userEntity.setAccountNonExpired(user.getAccountNonExpired());
        userEntity.setAccountNonLocked(user.getAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.getCredentialsNonExpired());
        userEntity.setEnabled(user.getEnabled());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setBirthdate(user.getBirthdate());
        userEntity.setPostalCode(user.getPostalCode());
        userEntity.setCity(user.getCity());
        userEntity.setDeliveryAddress(user.getDeliveryAddress());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity){
        //return mapper.map(userEntity, User.class);

        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setFirstname(userEntity.getFirstname());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        user.setBirthdate(userEntity.getBirthdate());
        user.setPostalCode(userEntity.getPostalCode());
        user.setCity(userEntity.getCity());
        user.setDeliveryAddress(userEntity.getDeliveryAddress());
        return user;
    }

    public TranslationCategory categoryEntityToCategoryModel(TranslationCategoryEntity categoryEntity){
        return mapper.map(categoryEntity, TranslationCategory.class);
    }

    public TranslationProduct productEntityToProductModel(TranslationProductEntity productEntity){
        return mapper.map(productEntity, TranslationProduct.class);
    }
}
