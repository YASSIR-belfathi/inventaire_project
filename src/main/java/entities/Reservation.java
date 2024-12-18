package entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String vol_reserve;
	@Column
	private String passager_reservant;
	@Column
	private Date date_reservation;
	@Column
	private String status;
	@Column
	private int prix_total;
	public Reservation() {};
	public Reservation(String vol_reserve, String passager_reservant, Date date_reservation, String status,
			int prix_total) {
		this.vol_reserve = vol_reserve;
		this.passager_reservant = passager_reservant;
		this.date_reservation = date_reservation;
		this.status = status;
		this.prix_total = prix_total;
	}
	
	public String getPassager_reservant() {
		return passager_reservant;
	}
	public void setPassager_reservant(String passager_reservant) {
		this.passager_reservant = passager_reservant;
	}
	public Date getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(Date date) {
		this.date_reservation = date;
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
    @ManyToOne
    @JoinColumn(name = "vol_id", nullable = false)
    private vol vol;
    //plusieurs reservations peut concerner un seul passager
    @ManyToOne
    @JoinColumn(name = "passager_id", nullable = false)
    @JsonIgnore
    private Passager passager;
    //pour qu'un passager peut reserver pour lui-meme et d'autres passagers
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passager> additionalPassengers = new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Passager> getAdditionalPassengers() {
		return additionalPassengers;
	}
	public void setAdditionalPassengers(List<Passager> additionalPassengers) {
		this.additionalPassengers = additionalPassengers;
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
