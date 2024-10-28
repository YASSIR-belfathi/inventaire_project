package entities;
import jakarta.persistence.*;

@Entity
public class administrateur extends User {
	public administrateur(String email, String password, String nom_complet,int telephone ) {
		super(email, password, nom_complet);
	} 
	
}
