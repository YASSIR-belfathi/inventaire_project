package com.inventaire.vol1.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Membre_equipage {

    //attributs for class(Entity)
    private enum type_membre{
        Membre_normal,
        Copilot,
        Pilot
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_membre_equipage;
    @Column
    private String nom_complet;
    @Column
    private type_membre Type_membre;
    @Column
    private String nationnalite;
    @Column
    private String num_licence;
    @ManyToOne
    @JoinColumn(name = "id_vol", nullable = false)
    private Vol vol;

    //Constructor
    public Membre_equipage() {
    }

    public Membre_equipage(String nom_complet, type_membre Type_membre, String nationnalite, String num_licence) {
        this.nom_complet = nom_complet;
        this.Type_membre = Type_membre;
        this.nationnalite = nationnalite;
        this.num_licence = num_licence;
    }

    //getter and setters for attributs
    public int getID_membre_equipage() {
        return ID_membre_equipage;
    }
    public void setID_membre_equipage(int ID_membre_equipage) {
        this.ID_membre_equipage = ID_membre_equipage;
    }
    public String getNom_complet() {
        return nom_complet;
    }
    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }
    public type_membre getType_membre() {
        return Type_membre;
    }
    public void setType_membre(type_membre Type_membre) {
        this.Type_membre = Type_membre;
    }
    public String getNationnalite() {
        return nationnalite;
    }
    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }
    public String getNum_licence() {
        return num_licence;
    }
    public void setNum_licence(String num_licence) {
        this.num_licence = num_licence;
    }

    //override of toString() method
    @Override
    public String toString() {
        return "Membre_equipage [ID_membre_equipage=" + this.ID_membre_equipage + ", nom_complet=" + this.nom_complet
                + ", Type_membre=" + this.Type_membre + ", nationnalite=" + this.nationnalite + ", num_licence=" + this.num_licence
                + "]";
    }

    
}
