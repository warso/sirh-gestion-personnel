package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurControlleur extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {

		// récupère la valeur d'un paramètre dont le nom est avecPhoto

		String avecParam = req.getParameter("Matricule");
		resp.setContentType("text/html");
		if (avecParam != null) {

			// code HTML écrit dans le corps de la réponse
			resp.getWriter().write("<h1>Edition de collaborateur</h1>" + avecParam);
		}

		else {
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {

		String matriculeParam = req.getParameter("Matricule");
		String titreParam = req.getParameter("Titre");
		String nomParam = req.getParameter("Nom");
		String prenomParam = req.getParameter("Prenom");

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		if (matriculeParam != null && titreParam != null && nomParam != null && prenomParam != null) {

			resp.setStatus(201);
			// code HTML écrit dans le corps de la réponse
			resp.getWriter().write("<h1>Création d'un collaborateur avec les informations suivantes :</h1>"

					+ "<ul>"

					+ "<li>Matricule=" + matriculeParam + "</li>"

					+ "<li>Titre=" + titreParam + "</li>"

					+ "<li>Nom=" + nomParam + "</li>"

					+ "<li>Prenom=" + prenomParam + "</li>"

					+ "</ul>");

		}

		else {
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects : <br />");
			if (matriculeParam == null) {
				resp.getWriter().write("Matricule ");
			}
			if (titreParam == null) {
				resp.getWriter().write("Titre ");
			}
			if (nomParam == null) {
				resp.getWriter().write("Nom ");
			}
			if (prenomParam == null) {
				resp.getWriter().write("Prenom ");
			}
		}

	}
}
