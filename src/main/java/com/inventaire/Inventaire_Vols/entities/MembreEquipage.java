package com.inventaire.Inventaire_Vols.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembreEquipage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nom_complet;

	private String fonction;

	private String num_licence;

	private String nationalite;
	@ManyToOne()
	@JoinColumn(name = "volId")
	private Vol vol;
	@OneToOne
	private Role role;
	
	
	
}
