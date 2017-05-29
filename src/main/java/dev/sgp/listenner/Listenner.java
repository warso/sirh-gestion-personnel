package dev.sgp.listenner;

import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class Listenner implements ServletContextListener {
	@Inject
	private CollaborateurService collabService;
	@Inject
	private DepartementService depService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		depService.sauvegarderDepartement(new Departement(1, "Comptabilité"));
		depService.sauvegarderDepartement(new Departement(2, "Ressources Humaines"));
		depService.sauvegarderDepartement(new Departement(3, "Informatique"));
		depService.sauvegarderDepartement(new Departement(4, "Administratif"));
		
		Collaborateur collabo = new Collaborateur("gerrard", "steven", LocalDate.parse("1993-06-25"),
				"12 rue de liverpool", "147852369741258", "steven.gerrard@societe.com");
		collabo.setDepartement(new Departement(1,"Comptabilité"));
		collabService.sauvegarderCollaborateur(collabo);
		
		Collaborateur collabo1 = new Collaborateur("beyne", "ben", LocalDate.parse("1995-10-20"),
				"12 rue des cookies", "147852369741451", "ben.beyne@societe.com");
		collabo1.setDepartement(new Departement(3,"Informatique"));
		collabService.sauvegarderCollaborateur(collabo1);
		
		Collaborateur collabo2 = new Collaborateur("lavaud", "franc", LocalDate.parse("1992-10-28"),
				"12 rue de cerise", "541852369741451", "franc.lavaud@societe.com");
		collabo2.setDepartement(new Departement(4,"Administratif"));
		collabService.sauvegarderCollaborateur(collabo2);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
