package entities;
import jakarta.persistence.*;

@Entity
public class administrateur extends User {
	public administrateur(String email, String password, String FirstName,String LastName ) {
		super(email, password, FirstName, LastName);
	} 
	public administrateur() {}
}
