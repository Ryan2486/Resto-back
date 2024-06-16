package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Repository.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<CommandeModel> findAll() {
        return commandeRepository.findAll();
    }

    public Optional<CommandeModel> findById(String id) {
        return commandeRepository.findById(id);
    }

    public CommandeModel save(CommandeModel commandeModel) {
        return commandeRepository.save(commandeModel);
    }

    public void deleteById(String id) {
        commandeRepository.deleteById(id);
    }
    
}
