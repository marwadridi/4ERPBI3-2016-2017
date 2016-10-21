package tn.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.persistance.ConditionDeConservation;
import tn.esprit.persistance.ProduitAlimentaire;
import tn.esprit.services.GestionMagasinServiceRemote;

public class Question2 {

	public static void main(String[] args) throws NamingException {

		// 2 - ajouter une condition de conservation
		// et l'affecter à un produit deja existant.
		String jndiName="revision-ear/revision-ejb/GestionMagasinService"
				+ "!tn.esprit.services.GestionMagasinServiceRemote";
		Context context = new InitialContext();
		GestionMagasinServiceRemote proxy=(GestionMagasinServiceRemote) 
				context.lookup(jndiName);
		
		ConditionDeConservation c= new ConditionDeConservation();
		c.setHumidite(1.2F);
		proxy.ajouterConditionConservation(c);
		
		c.setId(4);
		ProduitAlimentaire p=(ProduitAlimentaire)
				proxy.chercherParId(1);
		
		
		proxy.affecterConditionAUnProduit(p, c);
		

	}

}
