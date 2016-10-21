package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Competence;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Laboratoire;
import tn.esprit.persistance.Technicien;

@Remote
public interface EmployeServiceRemote {

	void ajouterEmploye(Employe employe);

	void supprimerEmploye(Employe employe);

	Employe chercherEmploye(int id);

	void modifierEmploye(Employe employe);

	List<Technicien> retournerTousLesTechniciens();

	List<Chercheur> retournerTousLesChercheurs();
	
	void affecterContactEmploye(Contact contact,Employe employe);
	
	void ajouterContact(Contact contact);
	
	void affecterEmployeLabo(Laboratoire labo,Employe employe);
	
	void ajouterLabo(Laboratoire laboratoire);
	
	void affecterTechnicienCompetence(Technicien technicien,
			Competence competence);
	

	void affecterTechnicienCompetences(Technicien technicien,
			List<Competence> competences);
	
	void ajouterCompetence(Competence competence);
	
	Employe identifierEmploye(String login,String password);
	
	

	
}
