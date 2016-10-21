package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.persistance.ConditionDeConservation;
import tn.esprit.persistance.Marchandise;
import tn.esprit.persistance.ProduitAlimentaire;

@Remote
public interface GestionMagasinServiceRemote {
	
	
	void ajouterMarchandise(Marchandise marchandise);
	
	
	void ajouterConditionConservation
	   (ConditionDeConservation conditionDeConservation);
	
	
	void affecterConditionAUnProduit(ProduitAlimentaire p
			,ConditionDeConservation c);


	Marchandise chercherParId(int i);

}
