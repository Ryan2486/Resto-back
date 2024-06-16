package com.example.demo.Model;

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
public class ContenueMondel {

  @Id
  @Column(name = "idcontenir")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String idcontenir;

  @Column(name = "qte")
  private String qte;

  @ManyToOne
  @JoinColumn(name = "idplat", referencedColumnName = "idplat")
  private MenuModel menu;

  @ManyToOne
  @JoinColumn(name = "idcom", referencedColumnName = "idcom")
  private CommandeModel commande;

}
