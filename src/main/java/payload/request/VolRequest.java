package payload.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;


public class VolRequest {
    @NotBlank
    private int num_vol;
    @NotBlank
    private String vol_IATA;
    @NotBlank
	private Date date_vol_depart;
    @NotBlank
	private Date date_vol_arrive;
    @NotBlank
	private int prix_vol;
    @NotBlank
	private String aeroport_depart;
    @NotBlank
    private String aeroport_arrive;
    @NotBlank
    private int capacite;
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
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public Date getDate_vol_depart() {
		return date_vol_depart;
	}
	public void setDate_vol_depart(Date date_vol_depart) {
		this.date_vol_depart = date_vol_depart;
	}
	public Date getDate_vol_arrive() {
		return date_vol_arrive;
	}
	public void setDate_vol_arrive(Date date_vol_arrive) {
		this.date_vol_arrive = date_vol_arrive;
	}
	public int getPrix_vol() {
		return prix_vol;
	}
	public void setPrix_vol(int prix_vol) {
		this.prix_vol = prix_vol;
	}
}
