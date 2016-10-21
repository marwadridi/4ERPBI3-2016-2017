package tn.esprit.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Competence;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Laboratoire;
import tn.esprit.persistance.Technicien;

public class EmployeServiceTest {

	public static void main(String[] args) throws NamingException {

		String jndiName = "gestion.laboratoire-ear/gestion.laboratoire-ejb" + "/EmployeService"
				+ "!tn.esprit.interfaces.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote proxy = (EmployeServiceRemote) context.lookup(jndiName);

		// 1- ajout d'un employe :

		Technicien t = new Technicien();
		t.setNom("nom");
		t.setPrenom("prenom");
		t.setSpecialite("sp1");
		// proxy.ajouterEmploye(t);

		// 2- rechercher un employe par ID :

		// Technicien technicien=(Technicien) proxy.chercherEmploye(1);

		// System.out.println(technicien.getNom());

		// 3- suppression d'un employé :

		// proxy.supprimerEmploye(technicien);

		// 4 - modifier Employé :

		t.setNom("nom modifié");
		t.setId(5);
		// t=(Technicien) proxy.chercherEmploye(5);
		// proxy.modifierEmploye(t);
		// 5 - retourner tous les Employés :

		List<Technicien> techs = proxy.retournerTousLesTechniciens();

		for (Technicien technicien : techs) {
			System.out.println(technicien);
		}

		// 6 - affecter un contact à l'employé :

		Contact contact = new Contact();
		contact.setAdresse("tunis");
		contact.setEmail("contact@esprit.tn");
		contact.setNumTel(22222222);

		// proxy.ajouterContact(contact);

		t.setId(5);
		contact.setId(1);
		// proxy.affecterContactEmploye(contact, t);

		// 7 - cascade ON persist :

		Chercheur chercheur = new Chercheur();
		Contact contact2 = new Contact();

		chercheur.setGrade("doctorant2");
		chercheur.setNom("x2");
		chercheur.setPrenom("y2");

		contact2.setAdresse("esprit22");
		contact2.setEmail("esprit@esprit.tn");
		contact2.setNumTel(22222222);

		// chercheur.setContact(contact2);

		/// proxy.ajouterEmploye(chercheur);

		// 8 - affecter un employé au labo : (sans cascade )

		Laboratoire laboratoire = new Laboratoire();
		laboratoire.setAdresse("esprit");
		laboratoire.setNom("labo1");

		// proxy.ajouterLabo(laboratoire);

		laboratoire.setId(1);
		// chercheur.setId(8);
		// proxy.affecterEmployeLabo(laboratoire, chercheur);

		// 9 - utilisation du cascade (Employé/Labo) : ON MERGE

		chercheur.setId(7);
		chercheur.setLaboratoire(laboratoire);
		chercheur.setNom("nom modifié");

		laboratoire.setAdresse("adresse modifié");

		// proxy.modifierEmploye(chercheur);

		// 10 - test d'affectation Employé/ Competence (ManyToMany)

		Competence competence = new Competence();
		competence.setNom("java2");

		// proxy.ajouterCompetence(competence);

		t= (Technicien) proxy.chercherEmploye(2);
		 competence.setId(3);
		 //proxy.affecterTechnicienCompetence(t, competence);
		 
		 

		 //11 - chercher Employe Par Login et Mot de passe :
		 
		 Employe e= proxy.identifierEmploye("login", "pwd");
		 if(e instanceof Technicien)
			 System.out.println(((Technicien) e).getSpecialite());
		
		 if(e instanceof Chercheur)
			 System.out.println(((Chercheur) e).getGrade());
	}

}
