package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CommandeModel;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeModel, String> {

   @Query("SELECT c FROM Commande c WHERE c.datecom >= :startDate AND c.datecom <= :endDate")
    List<CommandeModel> findCommandesBetweenDates(Date startDate, Date endDate);
}
