package com.inventaire.Inventaire_Vols.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("AD")
@NoArgsConstructor

public class Administrateur extends User {

	//private String role;

}
