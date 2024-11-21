package com.inventaire.vol1.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Administrateur extends Utilisateur{

    @Column
    private String poste_travail;
    @OneToMany(mappedBy = "admin")
    private List<Vol> list_vol;

    public Administrateur(){
        
    }
    public Administrateur(String email, String password, int telephone, String nom_complet, String poste_travail,
            List<Vol> list_vol) {
        super(email, password, telephone, nom_complet);
        this.poste_travail = poste_travail;
        this.list_vol = list_vol;
    }
    public String getPoste_travail() {
        return poste_travail;
    }
    public void setPoste_travail(String poste_travail) {
        this.poste_travail = poste_travail;
    }
    public List<Vol> getList_vol() {
        return list_vol;
    }
    public void setList_vol(List<Vol> list_vol) {
        this.list_vol = list_vol;
    }
    @Override
    public String toString() {
        return "Administrateur [poste_travail=" + this.poste_travail + ", list_vol=" + this.list_vol + "]";
    }
}