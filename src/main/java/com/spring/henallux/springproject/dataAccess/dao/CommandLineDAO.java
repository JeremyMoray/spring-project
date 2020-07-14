package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.springproject.dataAccess.repository.CommandLineRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springproject.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommandLineDAO implements CommandLineDataAccess{

    private CommandLineRepository commandLineRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CommandLineDAO(CommandLineRepository commandLineRepository, ProviderConverter providerConverter){
        this.commandLineRepository = commandLineRepository;
        this.providerConverter = providerConverter;
    }

    public CommandLine save(CommandLine commandLine){
        CommandLineEntity commandLineEntity = providerConverter.commandLineModelToCommandLineEntity(commandLine);
        commandLineEntity = commandLineRepository.save(commandLineEntity);
        return providerConverter.commandLineEntityToCommandLineModel(commandLineEntity);
    }
}
