package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static java.util.stream.Collectors.*;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class VisiteWebService {

	@PersistenceContext(unitName = "sgp-pu") EntityManager emfact;

	public List<VisiteWeb> listerVisites() {
		
		TypedQuery<VisiteWeb> query = emfact.createQuery("select c from VisiteWeb c", VisiteWeb.class);

		return query.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sauvegarderVisite(VisiteWeb visite) {
		emfact.persist(visite);
	}

	public List<VisiteLog> construireStatistiques() {
		List<VisiteLog> listVisitesLog = new ArrayList<>();

		Map<String, List<VisiteWeb>> cheminListeVisites = emfact.createQuery("select c from VisiteWeb c", VisiteWeb.class).getResultList().stream()
				.collect(groupingBy(VisiteWeb::getChemin));

		cheminListeVisites.forEach((chemin, listeVisites) -> {
			listVisitesLog.add(construireVisiteLog(chemin, listeVisites));
		});

		return listVisitesLog;
	}

	public VisiteLog construireVisiteLog(String chemin, List<VisiteWeb> listeVisites) {
		
		LongSummaryStatistics stats = listeVisites.stream().collect(summarizingLong(VisiteWeb::getTempsExecution));
		return new VisiteLog(chemin, stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
	}

}