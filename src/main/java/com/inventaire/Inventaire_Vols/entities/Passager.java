package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Passager extends User {
	@Column
	private int numPasseport;
	@Column
	private String numID;
	@Column
	private String nationalite;
	@Column
	private String adresse;
	@Column
	private int telephone;
}
