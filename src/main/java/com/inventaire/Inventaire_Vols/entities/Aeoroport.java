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
	@ManyToMany(mappedBy = "aeoroports",fetch = FetchType.EAGER)

	@JoinTable(
			name = "aeoroport_avion",
			joinColumns = @JoinColumn(name = "aeoroportId"),
			inverseJoinColumns = @JoinColumn(name = "avionId")
	)
	private List<Avion> avions=new ArrayList<>();


	
}
