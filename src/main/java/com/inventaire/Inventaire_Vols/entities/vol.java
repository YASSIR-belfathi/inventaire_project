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
public class vol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private int num_vol;
	@Column
	private String vol_IATA;
	@Column
	private Date date_vol;
	@Column
	private String aeroport_depart;
	@Column
	private String aeroport_arrive;
	
}
