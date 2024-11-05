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
	@Column
	private String type_avion;
    @Column
	private int capacite;
    @Column
	private Date annee_fabrication;
    @Column
	private String model;
    @ManyToMany(mappedBy = "avions")
    private List<Aeoroport> aeoroports;
    
}
