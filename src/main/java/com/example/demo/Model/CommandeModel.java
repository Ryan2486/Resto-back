package com.example.demo.Model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMMANDE")
public class CommandeModel {

    @Id
    @Column(name = "idcom")
    private String idcom;

    @Column(name = "nomcli")
    private String nomcli;

    @Column(name = "typecom")
    private String typecom;

    @Column(name = "datecom")
    private Date datecom;

    @JsonIgnore
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private Set<ContenueModel> contenue;

    @ManyToOne
    @JoinColumn(name = "idtable", referencedColumnName = "idtable")
    private TableModel table;

    // Getters and setters
    public String getIdcom() {
        return idcom;
    }

    public void setIdcom(String idcom) {
        this.idcom = idcom;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getTypecom() {
        return typecom;
    }

    public void setTypecom(String typecom) {
        this.typecom = typecom;
    }

    public Date getDatecom() {
        return datecom;
    }

    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }

    public Set<ContenueModel> getContenue() {
        return contenue;
    }

    public void setContenue(Set<ContenueModel> contenue) {
        this.contenue = contenue;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = table;
    }
}
