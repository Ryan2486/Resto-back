package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TableModel;
import com.example.demo.Service.TableService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<TableModel> getAllTables() {
        return tableService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableModel> getTableById(@PathVariable String id) {
        Optional<TableModel> tableModel = tableService.findById(id);
        return tableModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TableModel createTable(@RequestBody TableModel tableModel) {
        if (tableService.findById(tableModel.getIdtable()).isPresent()) {
            throw new EntityExistsException("Table N°:" + tableModel.getIdtable() + " existe déjà");

        }
        return tableService.save(tableModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableModel> updateTable(@PathVariable String id, @RequestBody TableModel tableModel) {
        Optional<TableModel> existingTable = tableService.findById(id);
        if (existingTable.isPresent()) {
            return ResponseEntity.ok(tableService.save(tableModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable String id) {
        if (tableService.findById(id).isPresent()) {
            try {
                tableService.deleteById(id);
            } catch (Exception e) {
                if (e instanceof DataIntegrityViolationException) {
                    throw new DataIntegrityViolationException("Erreur lors de la suppression de la table N°" + id
                            + " ,la table est utilisée dans une réservation ou une commande");
                }
            }
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
