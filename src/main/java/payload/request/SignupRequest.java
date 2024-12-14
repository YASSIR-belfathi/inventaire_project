package payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String FirstName;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String LastName;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String Nationalite;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String CIN;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private int numPass;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private LocalDate DateNaissance;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private int Telephone; 
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
 
    private Set<String> role;


	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getNationalite() {
		return Nationalite;
	}

	public void setNationalite(String nationalite) {
		this.Nationalite = nationalite;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}
	public int getNumPass() {
		return numPass;
	}

	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}

	public LocalDate getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.DateNaissance = dateNaissance;
	}

	public int getTelephone() {
		return Telephone;
	}

	public void setTelephone(int telephone) {
		this.Telephone = telephone;
	}

}