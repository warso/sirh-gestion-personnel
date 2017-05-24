package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.service.ActiviteService;

@WebServlet("/collab/activites")
public class ActivitesController extends HttpServlet {

	@Inject
	private ActiviteService activiteService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<CollabEvt> activites = activiteService.listerActivitesCollab();

		req.setAttribute("activites", activites);
		req.getRequestDispatcher("/WEB-INF/views/collab/activites.jsp").forward(req, resp);
	}
}
