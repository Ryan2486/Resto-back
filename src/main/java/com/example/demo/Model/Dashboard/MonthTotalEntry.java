package com.example.demo.Model.Dashboard;

public class MonthTotalEntry {
  private String mois;
  private int Recette;

  public MonthTotalEntry(String mois, int total) {
    this.mois = mois;
    this.Recette = total;
  }

  public String getMois() {
    return mois;
  }

  public void setMois(String mois) {
    this.mois = mois;
  }

  public int getRecette() {
    return Recette;
  }

  public void setRecette(int Recette) {
    this.Recette = Recette;
  }
}
