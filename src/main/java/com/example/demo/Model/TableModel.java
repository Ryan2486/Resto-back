package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "_TABLE")
public class TableModel {
    @Id
    @Column(name = "idtable")
    private String idtable;

    @Column(name = "designation")
    private String designation;

    // Getters and setters
    public String getIdtable() {
        return idtable;
    }

    public void setIdtable(String idtable) {
        this.idtable = idtable;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
