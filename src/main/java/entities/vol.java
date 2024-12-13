package entities;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
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
	@Column(nullable = false)
	private int capacite;

	@Column(nullable = false)
	private int places_reservees = 0;

	public vol() {}
	public vol(int num_vol, String vol_IATA, Date date_vol, String aeroport_depart, String aeroport_arrive,int capacite,
			int places_reservees) {
		this.num_vol = num_vol;
		this.vol_IATA = vol_IATA;
		this.date_vol = date_vol;
		this.aeroport_depart = aeroport_depart;
		this.aeroport_arrive = aeroport_arrive;
		this.capacite = capacite;
		this.places_reservees = places_reservees;
	}
	public int getNum_vol() {
		return num_vol;
	}
	public void setNum_vol(int num_vol) {
		this.num_vol = num_vol;
	}
	public String getVol_IATA() {
		return vol_IATA;
	}
	public void setVol_IATA(String vol_IATA) {
		this.vol_IATA = vol_IATA;
	}
	public Date getDate_vol() {
		return date_vol;
	}
	public void setDate_vol(Date date_vol) {
		this.date_vol = date_vol;
	}
	public String getAeroport_depart() {
		return aeroport_depart;
	}
	public void setAeroport_depart(String aeroport_depart) {
		this.aeroport_depart = aeroport_depart;
	}
	public String getAeroport_arrive() {
		return aeroport_arrive;
	}
	public void setAeroport_arrive(String aeroport_arrive) {
		this.aeroport_arrive = aeroport_arrive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getPlaces_reservees() {
		return places_reservees;
	}
	public void setPlaces_reservees(int places_reservees) {
		this.places_reservees = places_reservees;
	}
	
	
}
