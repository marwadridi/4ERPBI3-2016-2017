package tn.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.persistance.Test;

/**
 * Session Bean implementation class TestService
 */
@Stateless
@LocalBean
public class TestService implements TestServiceRemote {

	@PersistenceContext(unitName="revision-ejb")
	EntityManager em;

	public TestService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterTest(Test test) {
		em.persist(test);

	}

}
