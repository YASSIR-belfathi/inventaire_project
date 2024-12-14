package entities;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Passager extends User{
    @Column
	private int numPass;
    @Column
	private String CIN;
    @Column
	private String nationalite;
    @Column
	private String adresse;
    @Column
	private int telephone;
    @Column
    private LocalDate DateNaissance;
    
	public Passager(String email, String password,  String FirstName, String LastName,
			int numPass,String CIN,String nationalite,String adresse, int telephone,LocalDate DateNaissance) {
		super(email, password, FirstName, LastName);
		// TODO Auto-generated constructor stub
		this.numPass = numPass;
		this.CIN = CIN;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.DateNaissance =  DateNaissance;
	}
	public Passager() {}
	public int getNumPass() {
		return numPass;
	}
	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String CIN) {
		this.CIN = CIN;
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
	public LocalDate getDateNaissance() {
		return DateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.DateNaissance = dateNaissance;
	}
}
