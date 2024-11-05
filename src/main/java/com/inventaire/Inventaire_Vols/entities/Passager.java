package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@OneToMany(mappedBy = "passager",fetch = FetchType.LAZY)
	private List<Reservation> reservations =new ArrayList<>();
}
