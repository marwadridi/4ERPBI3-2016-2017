package tn.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Technicien;

public class EmployeServiceTest {

	public static void main(String[] args) throws NamingException {
		
String jndiName="gestion.laboratoire-ear/gestion.laboratoire-ejb"
				+ "/EmployeService"
				+ "!tn.esprit.interfaces.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote proxy=(EmployeServiceRemote) 
				context.lookup(jndiName);
		
		
		// 1- ajout d'un employe :
		
		Technicien t = new Technicien();
		t.setNom("nom");
		t.setPrenom("prenom");
		t.setSpecialite("sp1");
		//proxy.ajouterEmploye(t);
		
		
		// 2- rechercher un employe par ID :
		
	   Technicien technicien=(Technicien) proxy.chercherEmploye(1);
		
		System.out.println(technicien.getNom());
		
		// 3- suppression d'un employé :
		
		
		proxy.supprimerEmploye(technicien);
		
		
		
		
		

	}

}
