package tn.esprit.interfaces;

import java.awt.Checkbox;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Technicien;

@Remote
public interface EmployeServiceRemote {

	void ajouterEmploye(Employe employe);

	void supprimerEmploye(Employe employe);

	Employe chercherEmploye(int id);

	void modifierEmploye(Employe employe);

	List<Technicien> retournerTousLesTechniciens();
	
	List<Chercheur> retournerTousLesChercheurs();

}
