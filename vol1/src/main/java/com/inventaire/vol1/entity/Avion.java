﻿package com.inventaire.vol1.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Avion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_avion;
    @Column
    private String type;
    @Column
    private int capacity;
    @Column
    private int year_manufacture;
    @Column
    private String model;
    @ManyToOne
    @JoinColumn(name = "id_aeroport", nullable = false)
    private Aeroport aeroport;

    @OneToMany(mappedBy = "avion")
    private List<Vol> list_vol;

    public Avion() {
    }
    public Avion(int ID_avion, String type, int capacity, int year_manufacture, String model) {
        this.ID_avion = ID_avion;
        this.type = type;
        this.capacity = capacity;
        this.year_manufacture = year_manufacture;
        this.model = model;
    }
    public int getID_avion() {
        return ID_avion;
    }
    public void setID_avion(int ID_avion) {
        this.ID_avion = ID_avion;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getYear_manufacture() {
        return year_manufacture;
    }
    public void setYear_manufacture(int year_manufacture) {
        this.year_manufacture = year_manufacture;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Avion [ID_avion=" + this.ID_avion + ", type=" + this.type + ", capacity=" + this.capacity + ", year_manufacture="
                + this.year_manufacture + ", model=" + this.model + "]";
    }
}