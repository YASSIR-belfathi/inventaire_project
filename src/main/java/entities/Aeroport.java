package entities;
import jakarta.persistence.*;

@Entity
public class Aeroport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String aeoroport_IATA;
	@Column
	private String nom_aeroport;
	@Column
	private String ville;
	@Column
	private String pays;
	@Column
	private int capacite;
	public Aeroport(String aeoroport_IATA, String nom_aeroport, String ville, String pays, int capacite) {
		this.aeoroport_IATA = aeoroport_IATA;
		this.nom_aeroport = nom_aeroport;
		this.ville = ville;
		this.pays = pays;
		this.capacite = capacite;
	}
	public String getAeoroport_IATA() {
		return aeoroport_IATA;
	}
	public void setAeoroport_IATA(String aeoroport_IATA) {
		this.aeoroport_IATA = aeoroport_IATA;
	}
	public String getNom_aeroport() {
		return nom_aeroport;
	}
	public void setNom_aeroport(String nom_aeroport) {
		this.nom_aeroport = nom_aeroport;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
