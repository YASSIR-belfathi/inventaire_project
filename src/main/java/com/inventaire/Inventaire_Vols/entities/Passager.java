package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("US")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Passager extends User {

	private int numPasseport;

	private String numID;

	private String nationalite;

	private String adresse;

	private String telephone;
	@OneToMany(mappedBy = "passager",fetch = FetchType.LAZY)
	private List<Reservation> reservations =new ArrayList<>();


}
