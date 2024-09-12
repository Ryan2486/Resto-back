package com.example.demo.Model.Dashboard;

import java.util.List;

public class DashboardModel {
  private List<MonthTotalEntry> RevenuParMois;
  private int TotalRecette;
  private List<Topplat> top10Plats;

  public DashboardModel(List<MonthTotalEntry> RevenuParMois, int TotalRecette, List<Topplat> top10Plats) {
    this.RevenuParMois = RevenuParMois;
    this.TotalRecette = TotalRecette;
    this.top10Plats = top10Plats;
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

  public List<Topplat> getTop10Plats() {
    return this.top10Plats;
  }

  public void setTop10Plats(List<Topplat> top10Plats) {
    this.top10Plats = top10Plats;
  }

}
