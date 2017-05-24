package dev.sgp.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;



@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ActiviteService {

	@PersistenceContext(unitName = "sgp-pu") EntityManager emfact;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void recevoirEvenementCollab(@Observes CollabEvt evt) {

		emfact.persist(evt);

	}

	
	public List<CollabEvt> listerActivitesCollab() {

		TypedQuery<CollabEvt> query = emfact.createQuery("select evt from CollabEvt evt", CollabEvt.class);

		return query.getResultList();

	}
	
}
