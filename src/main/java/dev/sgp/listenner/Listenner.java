package dev.sgp.listenner;


import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebListener
public class Listenner implements ServletContextListener {
	
	@Inject private CollaborateurService collabService;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
	Collaborateur collaborateur = new Collaborateur("Steven", "Gerrard", LocalDate.of(0, 1, 1), "12 rue de Liverpool", "123456789123456", "Steven.Gerrard@societe.com");
	List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
	collaborateurs.add(collaborateur);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}
