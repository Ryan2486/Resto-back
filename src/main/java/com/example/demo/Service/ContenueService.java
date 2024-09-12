package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ContenueModel;
import com.example.demo.Repository.ContenueRepository;

@Service
public class ContenueService {

  @Autowired
  private ContenueRepository contenueRepository;

  public ContenueModel save(ContenueModel contenue) {
    return contenueRepository.save(contenue);
  }

  public Optional<ContenueModel> findById(Integer id) {
    return contenueRepository.findById(id);
  }

  public void deleteById(Integer id) {
    contenueRepository.deleteById(id);
  }

  public List<ContenueModel> findAll() {
    return contenueRepository.findAll();
  }

  public Optional<List<ContenueModel>> findbycommande(String idcom) {
    return contenueRepository.findByCommandeModelId(idcom);
  }

  public ContenueModel updateContenue(ContenueModel contenue) {
    return contenueRepository.save(contenue);
  }
}
