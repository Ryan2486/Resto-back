package com.example.demo.Model.Dashboard;

import java.util.List;

public class DashboardModel {
  private List<MonthTotalEntry> RevenuParMois;
  private int TotalRecette;

  public DashboardModel(List<MonthTotalEntry> RevenuParMois, int TotalRecette) {
    this.RevenuParMois = RevenuParMois;
    this.TotalRecette = TotalRecette;
  }

  public List<MonthTotalEntry> getRevenuParMois() {
    return this.RevenuParMois;
  }

  public void setRevenuParMois(List<MonthTotalEntry> RevenuParMois) {
    this.RevenuParMois = RevenuParMois;
  }

  public int getTotalRecette() {
    return this.TotalRecette;
  }

  public void setTotalRecette(int TotalRecette) {
    this.TotalRecette = TotalRecette;
  }

}
