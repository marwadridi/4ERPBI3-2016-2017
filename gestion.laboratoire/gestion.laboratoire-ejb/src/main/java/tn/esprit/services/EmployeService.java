package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Technicien;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote, EmployeServiceLocal {

    /**
     * Default constructor. 
     */
    public EmployeService() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="gestion.laboratoire-ejb")
    EntityManager em;
    
    
	@Override
	public void ajouterEmploye(Employe employe) {
			em.persist(employe);
			
	}

	@Override
	public void supprimerEmploye(Employe employe) {
		em.remove(em.merge(employe));
		//ou bien
		//em.remove(em.find(Employe.class, employe.getId()));
	}

	@Override
	public Employe chercherEmploye(int id) {
		
		return em.find(Employe.class, id);
	}

	@Override
	public void modifierEmploye(Employe employe) {
			em.merge(employe);
	}

	@Override
	public List<Technicien> retournerTousLesTechniciens() {
		
		return em.createQuery("select t from Technicien t"
				,Technicien.class)
				.getResultList();
	}

	@Override
	public List<Chercheur> retournerTousLesChercheurs() {
		
		return em.createQuery("select c from Chercheur c"
				,Chercheur.class)
				.getResultList();
	}

}
