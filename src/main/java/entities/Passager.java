package entities;
import jakarta.persistence.*;

@Entity
public class Passager extends User{
    @Column
	private int num_passeport;
    @Column
	private String num_ID;
    @Column
	private String nationalite;
    @Column
	private String adresse;
    @Column
	private int telephone;
    
    public Passager(String email, String password, String nom_complet,int num_passeport,String num_ID,String nationalite,String adresse,int telephone) {
		super(email, password, nom_complet);
		this.num_passeport = num_passeport;
    	this.num_ID = num_ID;
    	this.nationalite = nationalite ;
    	this.adresse = adresse;
    	this.telephone = telephone;
	}
	public Passager() {}
	public int getNum_passeport() {
		return num_passeport;
	}
	public void setNum_passeport(int num_passeport) {
		this.num_passeport = num_passeport;
	}
	public String getNum_ID() {
		return num_ID;
	}
	public void setNum_ID(String num_ID) {
		this.num_ID = num_ID;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
    
    
}
