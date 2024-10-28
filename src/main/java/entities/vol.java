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
	public vol(int num_vol, String vol_IATA, Date date_vol, String aeroport_depart, String aeroport_arrive) {
		this.num_vol = num_vol;
		this.vol_IATA = vol_IATA;
		this.date_vol = date_vol;
		this.aeroport_depart = aeroport_depart;
		this.aeroport_arrive = aeroport_arrive;
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
	
	
}
