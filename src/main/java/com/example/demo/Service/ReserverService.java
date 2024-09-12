package com.example.demo.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ReserverModel;
import com.example.demo.Repository.ReserverRepository;
import com.example.demo.Repository.TableRepository;

@Service
public class ReserverService {

    @Autowired
    private ReserverRepository reserverRepository;

    @Autowired
    private TableRepository tableRepository;

    public List<ReserverModel> findAll() {
        return reserverRepository.findAll();
    }

    public Optional<ReserverModel> findById(String id) {
        return reserverRepository.findById(id);
    }

    public ReserverModel save(ReserverModel reserverModel) {
        return reserverRepository.save(reserverModel);
    }

    public List<String> findAvailableTablesByDateAndTime(Date date, Time time,
            Time timefin) {

        System.out.println(tableRepository.findAvailableTablesByDateAndTime(new java.sql.Date(date.getTime()),
                time, timefin));
        return tableRepository.findAvailableTablesByDateAndTime(new java.sql.Date(date.getTime()), time, timefin);
    }

    public void deleteById(String id) {
        reserverRepository.deleteById(id);
    }
}
