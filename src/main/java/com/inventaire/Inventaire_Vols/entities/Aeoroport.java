package com.inventaire.Inventaire_Vols.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aeoroport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String aeoroport_IATA;
	@Column
	private String nom_aeroport;
	@Column
	private String ville;
	@Column
	private String pays;
	@Column
	private int capacite;


	
}
