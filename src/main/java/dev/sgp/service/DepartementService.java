package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.Departement;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class DepartementService {

	@PersistenceContext(unitName = "sgp-pu")
	EntityManager em;

	public List<Departement> listerDepartement() {
		TypedQuery<Departement> query2 = em.createQuery("select d from Departement d",
				Departement.class);
		return query2.getResultList();
	}

	public void sauvegarderDepartement(Departement departement) {
		em.persist(departement);
	}
}
