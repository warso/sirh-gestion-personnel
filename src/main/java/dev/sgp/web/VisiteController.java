package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class VisiteController extends HttpServlet {

	private VisiteWebService visiteService = Constantes.VISIT_SERVICE;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisiteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<VisiteWeb> visite = visiteService.listerVisites();

		request.setAttribute("visite", visite);

		request.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(request, response);
		
	}


}
