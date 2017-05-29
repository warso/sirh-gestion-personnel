package dev.sgp.entite;

import java.time.LocalDate;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Collaborateur {

	public Collaborateur(String nom, String prenom, LocalDate dateDeNaissance, String adresse, String numSecu,
			String emailPro) {
		super();
		this.matricule = nom+prenom;
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.emailPro = emailPro;
	}

	public Collaborateur() {
		super();

		this.actif = true;
		this.photo = "urls de l'image";
	}
	
	@Id
	private String matricule;
	

	private String nom;
	
	private String prenom;
	
	private LocalDate DateDeNaissance;
	
	private String adresse;

	private String numSecu;

	private String emailPro;
	
	private String photo;
	
	private ZonedDateTime dateHeureCreation;
	
	private boolean actif;
	
	private String intitulePoste;
	@ManyToOne
	private Departement departement;
	
	private String nomBanque;
	private String Iban;
	private String Bic;
	

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getIban() {
		return Iban;
	}

	public void setIban(String iban) {
		Iban = iban;
	}

	public String getBic() {
		return Bic;
	}

	public void setBic(String bic) {
		Bic = bic;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

}
