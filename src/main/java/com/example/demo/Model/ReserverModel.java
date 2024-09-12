package com.example.demo.Model;

import java.sql.Time;
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

    @Column(name = "date_reserve")
    private Date dateReserve;

    @Column(name = "nomcli")
    private String nomcli;

    @Column(name = "time")
    private Time time;

    @Column(name = "time_fin")
    private Time timeFin;

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

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
        this.dateReserve = dateReserve;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(Time timeFin) {
        this.timeFin = timeFin;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = table;
    }
}
