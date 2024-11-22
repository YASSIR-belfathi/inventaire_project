package com.inventaire.vol1.entity;

import jakarta.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    // private enum Type_user{
    //     utilisateur,
    //     administrateur
    // };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private int telephone;
    @Column
    private String nom_complet;
    
    public Utilisateur() {
    }

    public Utilisateur(String email, String password, int telephone, String nom_complet) {
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.nom_complet = nom_complet;
    }


    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getTelephone() {
        return this.telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String getNom_complet() {
        return nom_complet;
    }
    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }


    @Override
    public String toString() {
        return "utilisateur [ID=" + this.ID + ", email=" + this.email + ", password=" + this.password + ", telephone=" + this.telephone
                + ", nom_complet=" + this.nom_complet + "]";
    }

    
}

