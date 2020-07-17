package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.CommandEntity;
import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CommandRepository extends JpaRepository<CommandEntity, Integer> {

    CommandEntity findByDateAndUser(Date date, UserEntity user);
}
