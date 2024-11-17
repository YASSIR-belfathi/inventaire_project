package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "passagerId")

	private Passager passager;

	private Date dateReservation;

	private StatutReservation statutReservation;

	private int prixTotal;
	@ManyToOne()
	@JoinColumn(name = "volID")
	private Vol vol;
}
