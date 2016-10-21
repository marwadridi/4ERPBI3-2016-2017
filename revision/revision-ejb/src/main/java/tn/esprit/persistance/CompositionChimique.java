package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompositionChimique
 *
 */
@Entity

public class CompositionChimique implements Serializable {

	   
	@Id
	private String composant;
	private static final long serialVersionUID = 1L;

	public CompositionChimique() {
		super();
	}   
	public String getComposant() {
		return this.composant;
	}

	public void setComposant(String composant) {
		this.composant = composant;
	}
   
}
