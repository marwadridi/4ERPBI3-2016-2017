package tn.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.persistance.ProduitAlimentaire;
import tn.esprit.persistance.ProduitMenager;
import tn.esprit.services.GestionMagasinServiceRemote;

public class Question1 {

	public static void main(String[] args) throws NamingException {
		
		// ajouter 3 produits :
		
		String jndiName="revision-ear/revision-ejb/GestionMagasinService"
				+ "!tn.esprit.services.GestionMagasinServiceRemote";
		Context context = new InitialContext();
		GestionMagasinServiceRemote proxy=(GestionMagasinServiceRemote) 
				context.lookup(jndiName);
		
		ProduitAlimentaire p1=new ProduitAlimentaire();
		ProduitAlimentaire p2= new ProduitAlimentaire();
		ProduitMenager p3 =new ProduitMenager();
		
		
		p1.setNom("produit1");
		p1.setMarque("marque1");
		p1.setPrix(1200);
		p1.setBio(true);
		
		p2.setNom("produit2");
		p2.setMarque("marque2");
		p2.setBio(false);
		
		p3.setNom("pmenager");
		p3.setMarque("marque3");
		p3.setToxique(false);
		
		proxy.ajouterMarchandise(p1);
		proxy.ajouterMarchandise(p2);
		proxy.ajouterMarchandise(p3);
		

	}

}
