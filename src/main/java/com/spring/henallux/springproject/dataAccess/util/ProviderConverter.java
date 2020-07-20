package com.spring.henallux.springproject.dataAccess.util;

import com.spring.henallux.springproject.dataAccess.entity.*;
import com.spring.henallux.springproject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();
    public UserEntity userModelToUserEntity(User user){
        return mapper.map(user, UserEntity.class);
    }

    public User userEntityToUserModel(UserEntity userEntity){
        if(userEntity == null)
            return null;
        return mapper.map(userEntity, User.class);
    }

    public TranslationCategory categoryEntityToCategoryModel(TranslationCategoryEntity categoryEntity){
        if(categoryEntity == null)
            return null;
        return mapper.map(categoryEntity, TranslationCategory.class);
    }

    public TranslationProduct productEntityToProductModel(TranslationProductEntity productEntity){
        if(productEntity == null)
            return null;
        return mapper.map(productEntity, TranslationProduct.class);
    }

    public CommandEntity commandModelToCommandEntity(Command command){
        return mapper.map(command, CommandEntity.class);
    }

    public Command commandEntityToCommandModel(CommandEntity commandEntity){
        return mapper.map(commandEntity, Command.class);
    }

    public CommandLineEntity commandLineModelToCommandLineEntity(CommandLine commandLine){
        return mapper.map(commandLine, CommandLineEntity.class);
    }

    public CommandLine commandLineEntityToCommandLineModel(CommandLineEntity commandLineEntity){
        return mapper.map(commandLineEntity, CommandLine.class);
    }
}
