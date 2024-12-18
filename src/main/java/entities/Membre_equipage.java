package entities;
import jakarta.persistence.*;

@Entity
public class Membre_equipage {
	public enum Option{
		Membre_nomal,
		pilote,
		copilote
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String nom_complet;
	@Column
	private String fonction;
	@Column
	private String num_licence;
	@Column
	private String nationalite;
	@Column
	private Option option;
	public Membre_equipage(String nom_complet, String fonction, String num_licence, String nationalite, Option option) {
		this.nom_complet = nom_complet;
		this.fonction = fonction;
		this.num_licence = num_licence;
		this.nationalite = nationalite;
		this.option = option;
	}
	public String getNom_complet() {
		return nom_complet;
	}
	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getNum_licence() {
		return num_licence;
	}
	public void setNum_licence(String num_licence) {
		this.num_licence = num_licence;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Option getOption() {
		return option;
	}
	public void setOption(Option option) {
		this.option = option;
	}
	
	
	
}
