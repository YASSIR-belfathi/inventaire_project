package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aeroport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String aeoroportIATA;
	private String nomAeroport;
	private String ville;
	private String pays;
	private int capacite;

	@ManyToMany(mappedBy = "aeoroports", fetch = FetchType.EAGER)
	private List<Avion> avions = new ArrayList<>();
}
