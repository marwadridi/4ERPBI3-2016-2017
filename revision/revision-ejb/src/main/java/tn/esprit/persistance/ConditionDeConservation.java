package tn.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConditionDeConservation
 *
 */
@Entity

public class ConditionDeConservation implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private int temperature;
	private float humidite;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="conservation")
	private List<ProduitAlimentaire> produitAlimentaires;

	public ConditionDeConservation() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getTemperature() {
		return this.temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}   
	public float getHumidite() {
		return this.humidite;
	}

	public void setHumidite(float humidite) {
		this.humidite = humidite;
	}
	public List<ProduitAlimentaire> getProduitAlimentaires() {
		return produitAlimentaires;
	}
	public void setProduitAlimentaires(List<ProduitAlimentaire> produitAlimentaires) {
		this.produitAlimentaires = produitAlimentaires;
	}
   
}
