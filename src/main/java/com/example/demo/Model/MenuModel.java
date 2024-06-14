package com.example.demo.Model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MENU")
public class MenuModel {

    @Id
    @Column(name = "idplat")
    private String idplat;

    @Column(name = "nomplat")
    private String nomplat;

    @Column(name = "pu")
    private int pu;

    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private Set<CommandeModel> commandes;

    // Getters and setters
    public String getIdplat() {
        return idplat;
    }

    public void setIdplat(String idplat) {
        this.idplat = idplat;
    }

    public String getNomplat() {
        return nomplat;
    }

    public void setNomplat(String nomplat) {
        this.nomplat = nomplat;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public Set<CommandeModel> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<CommandeModel> commandes) {
        this.commandes = commandes;
    }
}
