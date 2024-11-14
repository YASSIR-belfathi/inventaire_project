package com.inventaire.vol1.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Reservation {

    //attributs of class
    private enum Status{
        en_cours,
        finie,
        // d'autres suggestions à ajouter
    }
    @Id
    @GeneratedValue
    private int ID_reservation;
    @ManyToMany(mappedBy = "list_reservation")
    private List<Passager> list_passager;
    @Column
    private LocalDate date_reservation;
    @Column
    private Status statu_reservation;
    @Column
    private Double prix;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vol_id", nullable = false)
    private Vol vol;

    //Constructor of class
    public Reservation() {
    }
    public Reservation(LocalDate date_reservation, Status statu_reservation, Double prix,
    List<Passager> list_passager, Vol vol ) {
        this.list_passager = list_passager;
        this.date_reservation = date_reservation;
        this.statu_reservation = statu_reservation;
        this.prix = prix;
        this.vol=vol;
    }

    //getters and setters of attributs
    public int getID_reservation() {
        return ID_reservation;
    }
    public void setID_reservation(int ID_reservation) {
        this.ID_reservation = ID_reservation;
    }
    public List<Passager> getList_passager_reservation() {
        return list_passager;
    }
    public void setList_passager_reservation(List<Passager> list_passager) {
        this.list_passager = list_passager;
    }
    public LocalDate getDate_reservation() {
        return date_reservation;
    }
    public void setDate_reservation(LocalDate date_reservation) {
        this.date_reservation = date_reservation;
    }
    public Status getStatu_reservation() {
        return statu_reservation;
    }
    public void setStatu_reservation(Status statu_reservation) {
        this.statu_reservation = statu_reservation;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    
    public List<Passager> getList_passager() {
        return list_passager;
    }
    public void setList_passager(List<Passager> list_passager) {
        this.list_passager = list_passager;
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }

    //override of toString() method.
    @Override
    public String toString() {
        return "Reservation [ID_reservation=" + this.ID_reservation + ", ID_vol_reservation="+ ", list_passager_reservation=" + ", date_reservation=" + this.date_reservation
                + ", statu_reservation=" + this.statu_reservation + ", prix=" + this.prix + "list_passager="+ this.list_passager+"vol="+this.vol+"]";
    }
}
