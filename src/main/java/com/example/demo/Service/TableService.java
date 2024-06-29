package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.TableModel;
import com.example.demo.Repository.TableRepository;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<TableModel> findAll() {
        return tableRepository.findAll();
    }

    public Optional<TableModel> findById(String id) {
        return tableRepository.findById(id);
    }

    public TableModel save(TableModel tableModel) {

        return tableRepository.save(tableModel);

    }

    public void deleteById(String id) {
        tableRepository.deleteById(id);
    }
}
