package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VisiteWeb {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	public VisiteWeb() {
		super();
	}

	private String chemin;
	private long tempsExecution;

	public VisiteWeb(String chemin, long tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public long getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
