package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTENIR")
public class ContenueModel {

  @Id
  @Column(name = "idcontenir")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idcontenir;

  @Column(name = "qte")
  private int qte;

  @ManyToOne
  @JoinColumn(name = "idplat", referencedColumnName = "idplat")
  private MenuModel menu;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "idcom", referencedColumnName = "idcom")
  private CommandeModel commande;

  // Getters and Setters
  public int getIdcontenir() {
    return idcontenir;
  }

  public void setIdcontenir(int idcontenir) {
    this.idcontenir = idcontenir;
  }

  public int getQte() {
    return qte;
  }

  public void setQte(int qte) {
    this.qte = qte;
  }

  public MenuModel getMenu() {
    return menu;
  }

  public void setMenu(MenuModel menu) {
    this.menu = menu;
  }

  public CommandeModel getCommande() {
    return commande;
  }

  public void setCommande(CommandeModel commande) {
    this.commande = commande;
  }
}
