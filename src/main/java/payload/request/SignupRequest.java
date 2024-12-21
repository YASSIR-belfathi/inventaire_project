package payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String first_name;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String last_name;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String nationalite;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String cin;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private int num_pass;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private LocalDate date_naissance;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private int telephone; 
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
 
    private String role;




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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	/*public String getFirstRole() {
        return role.stream().findFirst().orElse(null);
    }*/
	
	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public int getNum_pass() {
		return num_pass;
	}

	public void setNum_pass(int num_pass) {
		this.num_pass = num_pass;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}



}