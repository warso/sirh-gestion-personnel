package dev.sgp.entite;

public class VisiteWeb {

	private Integer id;
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
