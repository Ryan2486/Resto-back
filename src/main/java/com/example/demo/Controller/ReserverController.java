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

import com.example.demo.Model.ReserverModel;
import com.example.demo.Service.ReserverService;
import com.example.demo.Service.TableService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/reservations")
public class ReserverController {

    @Autowired
    private ReserverService reserverService;
    @Autowired
    private TableService tableService;

    @GetMapping
    public List<ReserverModel> getAllReservations() {
        return reserverService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserverModel> getReservationById(@PathVariable String id) {
        Optional<ReserverModel> reserverModel = reserverService.findById(id);

        return reserverModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReserverModel createReservation(@RequestBody ReserverModel reserverModel) {
        if (reserverService.findById(reserverModel.getIdreserv()).isPresent()) {
            throw new EntityExistsException("L'entité existe déjà");
        }

        List<String> availableTables = reserverService.findAvailableTablesByDateAndTime(reserverModel.getDateReserve(),
                reserverModel.getTime(), reserverModel.getTimeFin());
        if (!availableTables.contains(reserverModel.getTable().getIdtable())) {
            throw new IllegalStateException("La table sélectionnée est déjà prise");
        }

        return reserverService.save(reserverModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserverModel> updateReservation(@PathVariable String id,
            @RequestBody ReserverModel reserverModel) {
        Optional<ReserverModel> existingReservation = reserverService.findById(id);
        if (existingReservation.isPresent()) {

            List<String> availableTables = reserverService.findAvailableTablesByDateAndTime(
                    reserverModel.getDateReserve(),
                    reserverModel.getTime(), reserverModel.getTimeFin());
            if (!availableTables.contains(reserverModel.getTable().getIdtable())) {
                throw new IllegalStateException("La table sélectionnée est déjà prise");
            }

            ReserverModel updatedReservation = existingReservation.get();
            updatedReservation.setTable(reserverModel.getTable());
            updatedReservation.setDateDeReserv(reserverModel.getDateDeReserv());
            updatedReservation.setDateReserve(reserverModel.getDateReserve());
            updatedReservation.setNomcli(reserverModel.getNomcli());
            return ResponseEntity.ok(reserverService.save(updatedReservation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        if (reserverService.findById(id).isPresent()) {
            try {
                reserverService.deleteById(id);
            } catch (Exception e) {
                if (e instanceof DataIntegrityViolationException) {
                    throw new DataIntegrityViolationException("Erreur lors de la suppression de la réservation N°" + id
                            + " ,la réservation est utilisée dans une commande");
                }
            }
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
