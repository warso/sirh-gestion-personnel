package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class CollaborateurService {

	@PersistenceContext(unitName = "sgp-pu")
	EntityManager emfact;

	@Inject
	Event<CollabEvt> collabEvt;

	public List<Collaborateur> listerCollaborateurs() {

		TypedQuery<Collaborateur> query = emfact.createQuery("select c from Collaborateur c", Collaborateur.class);
		return query.getResultList();

	}

	public List<Collaborateur> listerCollaborateursParDepartement(Integer depId) {

		TypedQuery<Collaborateur> query = emfact
				.createQuery("select c from Collaborateur c where c.departement.id=:depId", Collaborateur.class)
				.setParameter("depId", depId);
		return query.getResultList();

	}

	public Collaborateur collabByMatricule(String matricule) {

		TypedQuery<Collaborateur> query = emfact
				.createQuery("select c from Collaborateur c where c.matricule=:matricule", Collaborateur.class)
				.setParameter("matricule", matricule);
		return query.getResultList().get(0);
	}

	public void modifCollab(String matricule, Collaborateur collabo) {

		Collaborateur collab = collabByMatricule(matricule);

		if (collab != null) {

			collab.setDateDeNaissance(collabo.getDateDeNaissance());
			collab.setEmailPro(collabo.getEmailPro());
			collab.setDepartement(collabo.getDepartement());
		}
	}

	public String recupBanque(String matricule) {

		Collaborateur collab = collabByMatricule(matricule);
		return collab.getNomBanque() + " - " + collab.getIban() + " - " + collab.getBic();

	}

	public void modifBanque(String matricule, Collaborateur collabo) {

		Collaborateur collab = collabByMatricule(matricule);

		if (collab != null) {
			collab.setNomBanque(collabo.getNomBanque());
			collab.setIban(collabo.getIban());
			collab.setBic(collabo.getBic());

		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sauvegarderCollaborateur(Collaborateur collab) {

		emfact.persist(collab);
		CollabEvt nouveauCollabEvt = new CollabEvt(collab.getDateHeureCreation(),
				TypeCollabEvt.valueOf("CREATION_COLLAB"), collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);

	}

}
