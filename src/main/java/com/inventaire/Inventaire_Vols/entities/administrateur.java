package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@NoArgsConstructor
@SuperBuilder
public class administrateur extends User {
	@Column
	private String role;

}
