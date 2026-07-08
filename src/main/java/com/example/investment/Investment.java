package com.example.investment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Investment {
    @Id
    private String id;
    private String name;
    @Column(name = "investment_value")
    private double value;
    private String acquisitionDate;
    private String type;

    protected Investment() {
    }

    public Investment(String id, String name, double value, String acquisitionDate, String type) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public String getType() {
        return type;
    }
}
