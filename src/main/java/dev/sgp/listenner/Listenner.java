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
		collabo.setDepartement(new Departement(1, "Comptabilité"));
		collabo.setNomBanque("BNP Paribas");
		collabo.setIban("FR76 3000 4019 5000 0065 9373 533");
		collabo.setBic("BNPANCNFRAA");
		collabService.sauvegarderCollaborateur(collabo);

		Collaborateur collabo1 = new Collaborateur("beyne", "ben", LocalDate.parse("1995-10-20"), "12 rue des cookies",
				"147852369741451", "ben.beyne@societe.com");
		collabo1.setDepartement(new Departement(3, "Informatique"));
		collabo1.setNomBanque("Societe General");
		collabo1.setIban("FR76 3000 30302 0000 5012 3456 178");
		collabo1.setBic("SOGEFRPP");
		collabService.sauvegarderCollaborateur(collabo1);

		Collaborateur collabo2 = new Collaborateur("lavaud", "franc", LocalDate.parse("1992-10-28"), "12 rue de cerise",
				"541852369741451", "franc.lavaud@societe.com");
		collabo2.setDepartement(new Departement(4, "Administratif"));
		collabo2.setNomBanque("La Banque Postale");
		collabo2.setIban("FR10 2004 1000 0102 8489 4Y02 027");
		collabo2.setBic("PSSTFRPPPAR");
		collabService.sauvegarderCollaborateur(collabo2);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
