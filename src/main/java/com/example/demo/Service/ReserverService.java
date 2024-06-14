package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ReserverModel;
import com.example.demo.Repository.ReserverRepository;

@Service
public class ReserverService {

    @Autowired
    private ReserverRepository reserverRepository;

    public List<ReserverModel> findAll() {
        return reserverRepository.findAll();
    }

    public Optional<ReserverModel> findById(String id) {
        return reserverRepository.findById(id);
    }

    public ReserverModel save(ReserverModel reserverModel) {
        return reserverRepository.save(reserverModel);
    }

    public void deleteById(String id) {
        reserverRepository.deleteById(id);
    }
}
