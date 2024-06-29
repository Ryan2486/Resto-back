package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Service.CommandeService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<CommandeModel> getAllCommandes() {
        return commandeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeModel> getCommandeById(@PathVariable String id) {
        Optional<CommandeModel> commandeModel = commandeService.findById(id);
        return commandeModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CommandeModel createCommande(@RequestBody CommandeModel commandeModel) {
        if (commandeService.findById(commandeModel.getIdcom()) == null) {
            throw new EntityExistsException("La Commande N°:" + commandeModel.getIdcom() + " existe déjà");
        }
        return commandeService.save(commandeModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeModel> updateCommande(@PathVariable String id,
            @RequestBody CommandeModel commandeModel) {
        Optional<CommandeModel> existingCommande = commandeService.findById(id);
        if (existingCommande.isPresent()) {
            CommandeModel updatedCommande = existingCommande.get();
            // updatedCommande.setMenu(commandeModel.getMenu());
            updatedCommande.setNomcli(commandeModel.getNomcli());
            updatedCommande.setTypecom(commandeModel.getTypecom());
            updatedCommande.setTable(commandeModel.getTable());
            updatedCommande.setDatecom(commandeModel.getDatecom());
            return ResponseEntity.ok(commandeService.save(updatedCommande));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable String id) {
        if (commandeService.findById(id).isPresent()) {
            commandeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
