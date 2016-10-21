package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Marchandise
 *
 */
@Entity

public class Marchandise implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String marque;
	private String nom;
	private float prix;
	private static final long serialVersionUID = 1L;

	public Marchandise() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
   
}
