package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
    boolean existsByEmail(String email);
}
