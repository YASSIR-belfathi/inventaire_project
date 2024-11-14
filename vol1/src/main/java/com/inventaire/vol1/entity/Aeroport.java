package com.inventaire.vol1.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_aeroport;
    @Column
    private String aeroport_IATA;
    @Column
    private String nom_aeroport;
    @Column
    private String ville;
    @Column
    private String pays;
    @Column
    private int capacite;
    @OneToMany(mappedBy = "aeroport")
    private List<Avion> list_avion;
    @OneToMany(mappedBy = "aeroport_depart")
    private List<Vol> list_vol_depart;
    @OneToMany(mappedBy = "aeroport_arrivee")
    private List<Vol> list_vol_arrive;

    public Aeroport() {
    }
    public Aeroport(int ID_aeroport, String aeroport_IATA, String nom_aeroport, String ville, String pays,
            int capacite) {
        this.ID_aeroport = ID_aeroport;
        this.aeroport_IATA = aeroport_IATA;
        this.nom_aeroport = nom_aeroport;
        this.ville = ville;
        this.pays = pays;
        this.capacite = capacite;
    }
    public int getID_aeroport() {
        return ID_aeroport;
    }
    public void setID_aeroport(int ID_aeroport) {
        this.ID_aeroport = ID_aeroport;
    }
    public String getAeroport_IATA() {
        return aeroport_IATA;
    }
    public void setAeroport_IATA(String aeroport_IATA) {
        this.aeroport_IATA = aeroport_IATA;
    }
    public String getNom_aeroport() {
        return nom_aeroport;
    }
    public void setNom_aeroport(String nom_aeroport) {
        this.nom_aeroport = nom_aeroport;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    @Override
    public String toString() {
        return "Aeroport [ID_aeroport=" + this.ID_aeroport + ", aeroport_IATA=" + this.aeroport_IATA + ", nom_aeroport="
                + this.nom_aeroport + ", ville=" + this.ville + ", pays=" + this.pays + ", capacite=" + this.capacite + "]";
    } 
}
