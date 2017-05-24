package dev.sgp.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollabEvt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public CollabEvt() {
	}

	private ZonedDateTime dateHeure;
	private TypeCollabEvt type;
	private String matricule;

	public CollabEvt(ZonedDateTime dateHeure, TypeCollabEvt type, String matricule) {
		super();
		this.dateHeure = dateHeure;
		this.type = type;
		this.matricule = matricule;
	}

	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public TypeCollabEvt getType() {
		return type;
	}

	public void setType(TypeCollabEvt type) {
		this.type = type;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String dateForm() {
		return this.dateHeure.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}

}
