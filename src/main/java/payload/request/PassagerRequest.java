package payload.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;


public class PassagerRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @NotBlank
	private int num_pass;
    @NotBlank
	private String cin;
    @NotBlank
	private String nationalite;
    @NotBlank
	private int telephone;
    @NotBlank
    private LocalDate date_naissance;
    
	public PassagerRequest( Long id,String email,  String password,  String first_name,
			 String last_name,  int num_pass,  String cin,  String nationalite,
			 int telephone,  LocalDate date_naissance) {
		super();
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.num_pass = num_pass;
		this.cin = cin;
		this.nationalite = nationalite;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
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
}
