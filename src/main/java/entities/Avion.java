package entities;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String type_avion;
    @Column
	private int capacite;
    @Column
	private Date annee_fabrication;
    @Column
	private String model;
    public Avion() {}
	public Avion(String type_avion, int capacite, Date annee_fabrication, String model) {
		this.type_avion = type_avion;
		this.capacite = capacite;
		this.annee_fabrication = annee_fabrication;
		this.model = model;
	}
	public String getType_avion() {
		return type_avion;
	}
	public void setType_avion(String type_avion) {
		this.type_avion = type_avion;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public Date getAnnee_fabrication() {
		return annee_fabrication;
	}
	public void setAnnee_fabrication(Date annee_fabrication) {
		this.annee_fabrication = annee_fabrication;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
    
}
