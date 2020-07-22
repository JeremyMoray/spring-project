package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.CommandEntity;
import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<CommandEntity, Integer> {

    @Query("select command " +
            "from CommandEntity command, UserEntity user " +
            "where command.user = user " +
            "and user = ?1 " +
            "and command.date =" +
            "(select max(command.date) " +
            "from CommandEntity command, UserEntity user " +
            "where user = ?1)"
    )
    CommandEntity findByUser(UserEntity user);
}
