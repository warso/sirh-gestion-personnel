package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	
	List<VisiteWeb> visite = new ArrayList<>();

	public List<VisiteWeb> listerVisites() {

		return visite;

	}

	public void sauvegarderVisite(VisiteWeb visit) {

		visite.add(visit);

	}

}
