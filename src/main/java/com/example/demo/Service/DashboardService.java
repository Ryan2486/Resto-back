package com.example.demo.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Repository.CommandeRepository;

public class DashboardService {
  @Autowired
  private CommandeRepository commandeRepository;

  public List<CommandeModel> commandesEntreMaintenantEtIlYaSixMois() {
    Date maintenant = new Date();

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, -6);
    Date startDate = calendar.getTime();
    List<CommandeModel> commandes = commandeRepository.findCommandesBetweenDates(startDate, maintenant);

    return commandes;
  }
}
