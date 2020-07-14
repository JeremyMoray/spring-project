package com.spring.henallux.springproject.dataAccess.repository;

import com.spring.henallux.springproject.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.springproject.dataAccess.entity.CommandLineEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLineEntity, CommandLineEntityId> {
}
