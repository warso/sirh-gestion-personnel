package dev.sgp.listenner;


import java.time.LocalDate;

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
	

		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}
