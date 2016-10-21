package tn.esprit.test;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.persistance.CompositionChimique;
import tn.esprit.persistance.ProduitMenager;
import tn.esprit.services.GestionMagasinServiceRemote;

public class Question3 {

	public static void main(String[] args) throws NamingException {

		// ajouter un produitMenager et deux composition chimiques 
		// et affecter les deux compositions chimiques au produitMenager
		// en utilisant seulement la méthode 
		//void ajouterMarchandise(Marchandise m);
		String jndiName="revision-ear/revision-ejb/GestionMagasinService"
				+ "!tn.esprit.services.GestionMagasinServiceRemote";
		Context context = new InitialContext();
		GestionMagasinServiceRemote proxy=(GestionMagasinServiceRemote) 
				context.lookup(jndiName);
		
		CompositionChimique c1 = new CompositionChimique();
		CompositionChimique c2 = new CompositionChimique();
		ProduitMenager p = new ProduitMenager();
		
		
		
		c1.setComposant("comp1");
		c2.setComposant("comp2");
		
		p.setCompositionChimiques(new ArrayList<>());
		p.getCompositionChimiques().add(c1);
		p.getCompositionChimiques().add(c2);
		
		proxy.ajouterMarchandise(p);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
