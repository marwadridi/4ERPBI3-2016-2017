package tn.esprit.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TraducteurService
 */
@Stateless
public class TraducteurService implements TraducteurServiceRemote {

	/**
	 * Default constructor.
	 */
	public TraducteurService() {
	}

	@EJB
	DictionnaireService dictionnaire;

	@Override
	public String traduire(String mot) {
		String existe = dictionnaire.getDict().get(mot);
		if (existe != null)

			return existe;

		return "mot n'existe pas";
	}

}
