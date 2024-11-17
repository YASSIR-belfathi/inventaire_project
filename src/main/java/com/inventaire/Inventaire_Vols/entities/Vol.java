package com.inventaire.Inventaire_Vols.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private int num_vol;

	private String vol_IATA;

	private Date date_vol;

	private String aeroport_depart;

	private String aeroport_arrive;
	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservations =new ArrayList<>();
	@OneToOne
	private Avion avion;
	@OneToMany(mappedBy = "vol",fetch = FetchType.LAZY)
	private List<MembreEquipage> membreEquipages=new ArrayList<>();
	
}
