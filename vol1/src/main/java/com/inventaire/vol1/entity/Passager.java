package com.inventaire.vol1.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Passager{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_passager;
    @Column
    private String nom_complet;
    @Column
    private String num_passport;
    @Column
    private String num_carte_identifie;
    @Column
    private String nationnalite;
    @Column
    private int telephone;
    @ManyToMany
    @JoinTable(name="passager_reservation", joinColumns = @JoinColumn(name="passager_id"))
    private List<Reservation> list_reservation;

    public Passager() {
    }

    public Passager(String nom_complet, String num_passport, String num_carte_identifie, String nationnalite,
            int telephone, List<Reservation> list_reservation) {
        this.nom_complet = nom_complet;
        this.num_passport = num_passport;
        this.num_carte_identifie = num_carte_identifie;
        this.nationnalite = nationnalite;
        this.telephone = telephone;
        this.list_reservation = list_reservation;
    }

    public String getNum_passport() {
        return num_passport;
    }
    public void setNum_passport(String num_passport) {
        this.num_passport = num_passport;
    }
    public String getNum_carte_identifie() {
        return num_carte_identifie;
    }
    public void setNum_carte_identifie(String num_carte_identifie) {
        this.num_carte_identifie = num_carte_identifie;
    }
    public String getNationnalite() {
        return nationnalite;
    }
    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    
    @Override
    public String toString() {
        return "Passager [ID_passager=" + ", num_passport=" + this.num_passport + ", num_carte_identifie="
                + this.num_carte_identifie + ", nationnalite=" + this.nationnalite +"list_reservation="+this.list_reservation +"]";
    }
    public List<Reservation> getList_reservation() {
        return list_reservation;
    }
    public void setList_reservation(List<Reservation> list_reservation) {
        this.list_reservation = list_reservation;
    }
    
}
