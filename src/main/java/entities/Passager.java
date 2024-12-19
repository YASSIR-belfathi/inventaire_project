package entities;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Passager extends User{
    
	@Column
	private int num_pass;
    @Column
	private String cin;
    @Column
	private String nationalite;

    @Column
	private int telephone;
    @Column
    private LocalDate date_naissance;
    
	public Passager(String email, String password,  String FirstName, String LastName,
			int numPass,String CIN,String nationalite, int telephone,LocalDate DateNaissance) {
		super(email, password, FirstName, LastName);
		// TODO Auto-generated constructor stub
		this.num_pass = numPass;
		this.cin = CIN;
		this.nationalite = nationalite;
		this.telephone = telephone;
		this.date_naissance =  DateNaissance;
	}
	public Passager() {}
		
	public int getNum_pass() {
		return num_pass;
	}
	public void setNum_pass(int num_pass) {
		this.num_pass = num_pass;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public LocalDate getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}
	//un passager peut avoir plusieurs reservations 
    @OneToMany(mappedBy = "passager")
    private List<Reservation> reservations;
    
    public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
