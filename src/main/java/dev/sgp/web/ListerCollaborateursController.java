package dev.sgp.web;

import java.io.IOException;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;


/**
 * Servlet implementation class ListerCollaborateursController
 */
//@WebServlet("/ListerCollaborateursController")

 @WebServlet("/collaborateurs/lister")

public class ListerCollaborateursController extends HttpServlet {
	 
	 @Inject private CollaborateurService collabService; 

	 
	private static final long serialVersionUID = 1L;
	// récupération du service

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerCollaborateursController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		request.setAttribute("collaborateurs", collaborateurs);
		
		request.getRequestDispatcher("/WEB-INF/views/collab/lister.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}


	}
