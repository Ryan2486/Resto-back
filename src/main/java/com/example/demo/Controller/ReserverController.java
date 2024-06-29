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

import com.example.demo.Model.ReserverModel;
import com.example.demo.Service.ReserverService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/reservations")
public class ReserverController {

    @Autowired
    private ReserverService reserverService;

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
        if (reserverService.findById(reserverModel.getIdreserv()) == null) {
            throw new EntityExistsException("L'entiter existe déjà");
        }
        return reserverService.save(reserverModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserverModel> updateReservation(@PathVariable String id,
            @RequestBody ReserverModel reserverModel) {
        Optional<ReserverModel> existingReservation = reserverService.findById(id);
        if (existingReservation.isPresent()) {
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
            reserverService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
