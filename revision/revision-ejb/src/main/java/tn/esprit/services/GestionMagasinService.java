package tn.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.persistance.ConditionDeConservation;
import tn.esprit.persistance.Marchandise;
import tn.esprit.persistance.ProduitAlimentaire;

/**
 * Session Bean implementation class GestionMagasinService
 */
@Stateless
@LocalBean
public class GestionMagasinService implements GestionMagasinServiceRemote {

    /**
     * Default constructor. 
     */
    public GestionMagasinService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="revision-ejb")
    EntityManager entityManager;
    
	@Override
	public void ajouterMarchandise(Marchandise marchandise) {
		entityManager.persist(marchandise);
		
	}

	@Override
	public void ajouterConditionConservation(ConditionDeConservation conditionDeConservation) {
		entityManager.persist(conditionDeConservation);
		
	}

	@Override
	public void affecterConditionAUnProduit(ProduitAlimentaire p, ConditionDeConservation c) {
		p.setConservation(c);
		entityManager.merge(p);
		
		
	}

	@Override
	public Marchandise chercherParId(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Marchandise.class, id);
	}

}
