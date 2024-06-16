package com.example.demo.Model.Dashboard;

import java.time.Month;

public class RevenuParMoisModel {
    private Month month;
    private double revenue;

    // Constructeurs, getters et setters
    public RevenuParMoisModel(Month month, double revenue) {
        this.month = month;
        this.revenue = revenue;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
