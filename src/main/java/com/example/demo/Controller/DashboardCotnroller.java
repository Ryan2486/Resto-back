package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Service.DashboardService;

@RestController
@RequestMapping("/api/Dashboard")
public class DashboardCotnroller {
  @Autowired
  private DashboardService dashboardService;

  @GetMapping("/commandes-derniers-six-mois")
  public List<CommandeModel> getCommandesEntreMaintenantEtIlYaSixMois() {
    return dashboardService.commandesEntreMaintenantEtIlYaSixMois();
  }
}
