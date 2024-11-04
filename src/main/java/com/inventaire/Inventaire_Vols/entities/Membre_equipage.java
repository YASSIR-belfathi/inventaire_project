package com.inventaire.Inventaire_Vols.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membre_equipage {
	public enum Option{
		Membre_nomal,
		pilote,
		copilote
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String nom_complet;
	@Column
	private String fonction;
	@Column
	private String num_licence;
	@Column
	private String nationalite;
	@Column
	private Option option;
	
	
	
}
