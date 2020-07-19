package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import com.spring.henallux.springproject.dataAccess.repository.UserRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess {

    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter){
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public User findByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    public User save(User user){
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    public boolean existsById(String username){
        return userRepository.existsById(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}

