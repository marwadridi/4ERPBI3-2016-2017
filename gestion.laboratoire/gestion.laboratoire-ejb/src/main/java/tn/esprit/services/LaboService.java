package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.interfaces.LaboServiceLocal;
import tn.esprit.persistance.Laboratoire;

/**
 * Session Bean implementation class LaboService
 */
@Stateless
@LocalBean
public class LaboService implements LaboServiceLocal {


	@PersistenceContext
	EntityManager entityManager;
	
	
    public LaboService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addOrUpdateLabo(Laboratoire labo) {
		entityManager.merge(labo);
		
	}

	@Override
	public void deleteLabo(Laboratoire laboratoire) {
		entityManager.remove(entityManager.merge(laboratoire));
		
	}

	@Override
	public Laboratoire findLabo(int id) {
		
		return entityManager.find(Laboratoire.class, id);
	}

	@Override
	public List<Laboratoire> findAllLabos() {
		
		return entityManager.createQuery
				("select l from Laboratoire l",
				Laboratoire.class)
				.getResultList();
	}

}
