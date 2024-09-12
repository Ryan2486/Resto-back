package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Dashboard.DashboardModel;
import com.example.demo.Service.DashboardService;

@RestController
@RequestMapping("/api/Dashboard")
public class DashboardCotnroller {

  @Autowired
  private DashboardService dashboardService;

  @GetMapping()
  public DashboardModel Contenue6mois() {
    DashboardModel dashboard = new DashboardModel(dashboardService.Contenue6mois(), dashboardService.SommeTotal(),
        dashboardService.findTop10Plats());
    return dashboard;
  }
}
