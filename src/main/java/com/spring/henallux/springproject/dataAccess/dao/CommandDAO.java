package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.CommandEntity;
import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import com.spring.henallux.springproject.dataAccess.repository.CommandRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springproject.model.Command;
import com.spring.henallux.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class CommandDAO implements CommandDataAccess {

    private CommandRepository commandRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CommandDAO(CommandRepository commandRepository, ProviderConverter providerConverter){
        this.commandRepository = commandRepository;
        this.providerConverter = providerConverter;
    }

    public Command save(Command command){
        CommandEntity commandEntity = providerConverter.commandModelToCommandEntity(command);
        commandEntity = commandRepository.save(commandEntity);
        return providerConverter.commandEntityToCommandModel(commandEntity);
    }

    public Command findByUser(User user){
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        CommandEntity commandEntity = commandRepository.findByUser(userEntity);
        return providerConverter.commandEntityToCommandModel(commandEntity);
    }
}
