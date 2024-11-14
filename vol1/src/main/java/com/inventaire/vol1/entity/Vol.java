package com.inventaire.vol1.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Vol {

    //attributs for class(Entity)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_vol;
    @Column
    private String num_vol;
    @Column
    private LocalDate date_vol;
    @Column
    private double duree;

    /* 
     * la variable duree est pour résoudre le problème qu'une avion est affectée à plusieurs vol,
     * donc on doit calculer la durée de chaque vol pour savoir si le vol que l'avion est en cours de réaliser
     * est terminée ou non pour accepter ou non le vol que l'administrateur veut affecter à cette avion.
     */

    //Entity Mapping
    @OneToMany(mappedBy = "vol")
    private List<Reservation> list_reservation;
    @OneToMany(mappedBy = "vol")
    private List<Membre_equipage> list_membre_equipage;
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Administrateur admin;

    /* 
     * pour les deux clés étrangéres id_aeroport_depart et id_aeroport_arrivee, c'est pour représenter la double
     * association dans le diagramme de classe, on doit une fois qu'on fois savoir quel est l'aeroport d'arrivee
     * d'un vol on peut utiliser la cle étrangéres qui pointe sur l'aeroport dans la table aeroport
     */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aeroport_depart")
    private Aeroport aeroport_depart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aeroport_arrivee")
    private Aeroport aeroport_arrivee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_avion")
    private Avion avion;

    //Constructors

    public Vol(String num_vol, LocalDate date_vol, double duree, Administrateur admin, Aeroport aeroport_depart,
            Aeroport aeroport_arrivee) {
        this.num_vol = num_vol;
        this.date_vol = date_vol;
        this.duree = duree;
        this.admin = admin;
        this.aeroport_depart = aeroport_depart;
        this.aeroport_arrivee = aeroport_arrivee;
    }

    
    public Vol() {
    }

    //getters and setters

    public int getID_vol() {
        return ID_vol;
    }

    public void setID_vol(int iD_vol) {
        ID_vol = iD_vol;
    }

    public String getNum_vol() {
        return num_vol;
    }

    public void setNum_vol(String num_vol) {
        this.num_vol = num_vol;
    }

    public LocalDate getDate_vol() {
        return date_vol;
    }

    public void setDate_vol(LocalDate date_vol) {
        this.date_vol = date_vol;
    }
    
    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public List<Reservation> getList_reservation() {
        return list_reservation;
    }
    public void setList_reservation(List<Reservation> list_reservation) {
        this.list_reservation = list_reservation;
    }

    //override of toString() method
    @Override
    public String toString() {
        return "Vol [ID_vol=" + this.ID_vol + ", num_vol=" + this.num_vol + ", date_vol=" + this.date_vol 
        + ", list_reservation=" + this.list_reservation + ", durre="+this.duree+"]";
    }
}
