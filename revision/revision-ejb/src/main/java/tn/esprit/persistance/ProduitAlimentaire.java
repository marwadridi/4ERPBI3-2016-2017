package tn.esprit.persistance;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.persistance.Marchandise;

/**
 * Entity implementation class for Entity: ProduitAlimentaire
 *
 */
@Entity

public class ProduitAlimentaire extends Marchandise implements Serializable {

	
	private boolean bio;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private ConditionDeConservation conservation;

	public ProduitAlimentaire() {
		super();
	}   
	public boolean getBio() {
		return this.bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}
   public ConditionDeConservation getConservation() {
	return conservation;
}
   public void setConservation(ConditionDeConservation conservation) {
	this.conservation = conservation;
}
}
