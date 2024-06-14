package com.example.demo.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVER")
public class ReserverModel {

    @Id
    @Column(name = "idreserv")
    private String idreserv;

    @Column(name = "date_de_reserv")
    private Date dateDeReserv;

    @Column(name = "date_reservé")
    private Date dateReservé;

    @Column(name = "nomcli")
    private String nomcli;

    @ManyToOne
    @JoinColumn(name = "idtable", referencedColumnName = "idtable")
    private TableModel table;

    // Getters and setters
    public String getIdreserv() {
        return idreserv;
    }

    public void setIdreserv(String idreserv) {
        this.idreserv = idreserv;
    }

    public Date getDateDeReserv() {
        return dateDeReserv;
    }

    public void setDateDeReserv(Date dateDeReserv) {
        this.dateDeReserv = dateDeReserv;
    }

    public Date getDateReservé() {
        return dateReservé;
    }

    public void setDateReservé(Date dateReservé) {
        this.dateReservé = dateReservé;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = table;
    }
}
