package entities;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String vol_reserve;
	/*modification*/
	/*@Column
	private String passager_reservant;*/
	@Column
	private String passagerNom;
	@Column
	private String passagerPrenom;
	@Column
	private int passagerAge;
	@Column
	private int nombrePlaces;


	@Column
	private Date date_reservation;
	/*modification*/


	@Column
	private String status;

	@Column
	private int prix_total;

	@ManyToOne
	@JoinColumn(name = "vol_id", nullable = false)
	private vol vol;

	public Reservation() {};
	/*
	public Reservation(String vol_reserve, String passager_reservant, Date date_reservation, String status,
			int prix_total) {
		this.vol_reserve = vol_reserve;
		this.passager_reservant = passager_reservant;
		this.date_reservation = date_reservation;
		this.status = status;
		this.prix_total = prix_total;
	}*/
/*modification*/

	public Reservation(String passagerNom, Long id, String vol_reserve, String passagerPrenom, int passagerAge, int nombrePlaces, Date date_reservation, String status, int prix_total) {
		this.passagerNom = passagerNom;
		this.id = id;
		this.vol_reserve = vol_reserve;
		this.passagerPrenom = passagerPrenom;
		this.passagerAge = passagerAge;
		this.nombrePlaces = nombrePlaces;
		this.date_reservation = date_reservation;
		this.status = status;
		this.prix_total = prix_total;
	}

	public String getVol_reserve() {
		return vol_reserve;
	}

	public void setVol_reserve(String vol_reserve) {
		this.vol_reserve = vol_reserve;
	}

	public String getPassagerNom() {
		return passagerNom;
	}

	public void setPassagerNom(String passagerNom) {
		this.passagerNom = passagerNom;
	}

	public String getPassagerPrenom() {
		return passagerPrenom;
	}

	public void setPassagerPrenom(String passagerPrenom) {
		this.passagerPrenom = passagerPrenom;
	}

	public int getPassagerAge() {
		return passagerAge;
	}

	public void setPassagerAge(int passagerAge) {
		this.passagerAge = passagerAge;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrix_total() {
		return prix_total;
	}

	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}

	//plusieurs reservations peut concerner un seul passager
    @ManyToOne
    @JoinColumn(name = "passager_id", nullable = false)
    @JsonIgnore
    private Passager passager;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public vol getVol() {
		return vol;
	}
	public void setVol(vol vol) {
		this.vol = vol;
	}
	public Passager getPassager() {
		return passager;
	}
	public void setPassager(Passager passager) {
		this.passager = passager;
	}

}
