package com.example.demo.Model.Dashboard;

import java.util.List;

public class DashboardModel {
  private List<RevenuParMoisModel> RevenuParMois;

  public DashboardModel(List<RevenuParMoisModel> RevenuParMois) {
    this.RevenuParMois = RevenuParMois;
  }

  public List<RevenuParMoisModel> getReservations() {
    return this.RevenuParMois;
  }

  public void setReservations(List<RevenuParMoisModel> RevenuParMois) {
    this.RevenuParMois = RevenuParMois;
  }

}
