package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type_avion;
    private int capacite;
    private Date annee_fabrication;
    private String model;

    @ManyToMany
    @JoinTable(
            name = "aeoroportAvion",
            joinColumns = @JoinColumn(name = "avionId"),
            inverseJoinColumns = @JoinColumn(name = "aeoroportId")
    )
    private List<Aeroport> aeoroports;

    @OneToOne
    private Vol vol;
}
