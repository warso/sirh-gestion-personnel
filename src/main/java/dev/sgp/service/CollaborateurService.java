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

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sauvegarderCollaborateur(Collaborateur collab) {

		emfact.persist(collab);
		CollabEvt nouveauCollabEvt = new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.valueOf("CREATION_COLLAB"),
				collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);

	}

}
