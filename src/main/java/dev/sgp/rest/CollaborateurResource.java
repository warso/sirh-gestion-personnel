package dev.sgp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;

import dev.sgp.service.CollaborateurService;

@Path("/collaborateur")
public class CollaborateurResource {

	@Inject
	private CollaborateurService collabService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer depId) {

		if (depId!=null) {
			List<Collaborateur> collaborateurs = collabService.listerCollaborateursParDepartement(depId);
			return collaborateurs;
		} else {
			List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
			return collaborateurs;
		}
	}
	
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur liste(@PathParam("matricule") String matricule) {
		
		Collaborateur collaborateurs = collabService.collabByMatricule(matricule);
		return collaborateurs;
	}
	
	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifCollab(@PathParam("matricule") String matricule, Collaborateur collabo){
		
		collabService.modifCollab(matricule, collabo);
	}
	
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public String listeBanque(@PathParam("matricule") String matricule) {

		return  collabService.recupBanque(matricule);
	}
	
	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifierBanque(@PathParam("matricule") String matricule, Collaborateur collabo){
		
		collabService.modifBanque(matricule, collabo);
	}
	

}
