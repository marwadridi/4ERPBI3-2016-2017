package tn.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.persistance.Marchandise;

/**
 * Entity implementation class for Entity: ProduitMenager
 *
 */
@Entity

public class ProduitMenager extends Marchandise implements Serializable {

	
	private boolean toxique;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<CompositionChimique> compositionChimiques;

	public ProduitMenager() {
		super();
	}   
	public boolean getToxique() {
		return this.toxique;
	}

	public void setToxique(boolean toxique) {
		this.toxique = toxique;
	}
	public List<CompositionChimique> getCompositionChimiques() {
		return compositionChimiques;
	}
	public void setCompositionChimiques(List<CompositionChimique> compositionChimiques) {
		this.compositionChimiques = compositionChimiques;
	}
   
}
