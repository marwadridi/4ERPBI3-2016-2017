package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Competence;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Laboratoire;
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

	@PersistenceContext(unitName = "gestion.laboratoire-ejb")
	EntityManager em;

	@Override
	public void ajouterEmploye(Employe employe) {
		em.persist(employe);

	}

	@Override
	public void supprimerEmploye(Employe employe) {
		em.remove(em.merge(employe));
		// ou bien
		// em.remove(em.find(Employe.class, employe.getId()));
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

		return em.createQuery("select t from Technicien t", Technicien.class).getResultList();
	}

	@Override
	public List<Chercheur> retournerTousLesChercheurs() {

		return em.createQuery("select c from Chercheur c", Chercheur.class).getResultList();
	}

	@Override
	public void affecterContactEmploye(Contact contact, Employe employe) {

		employe.setContact(contact);
		em.merge(employe);

	}

	@Override
	public void ajouterContact(Contact contact) {
		em.persist(contact);

	}

	@Override
	public void affecterEmployeLabo(Laboratoire labo, Employe employe) {
		employe.setLaboratoire(labo);
		em.merge(employe);

	}

	@Override
	public void ajouterLabo(Laboratoire laboratoire) {
		em.persist(laboratoire);

	}

	@Override
	public void affecterTechnicienCompetence(Technicien technicien, Competence competence) {
		
		if(technicien.getCompetences()==null)
			
			technicien.setCompetences(new ArrayList<Competence>());
		
		technicien.getCompetences().add(competence);
		em.merge(technicien);

	}

	@Override
	public void affecterTechnicienCompetences(Technicien technicien, List<Competence> competences) {
		if(technicien.getCompetences()==null)
			technicien.setCompetences(new ArrayList<Competence>());
		technicien.getCompetences().addAll(competences);
		
		em.merge(technicien);
		
		
	}

	@Override
	public void ajouterCompetence(Competence competence) {
		em.persist(competence);

	}

	@Override
	public Employe identifierEmploye(String login, String password) {
		
		Employe employe=null;
		String requete="select e from Employe e where e.login=:x "
				+ "and e.password=:y";
			try{	
		employe=em.createQuery(requete,Employe.class)
		.setParameter("x", login)
		.setParameter("y", password)
		.getSingleResult();
			}
			catch(NoResultException ex)
			{
				System.out.println("pas de résultat");
			}
	
		return employe;
	}

}
