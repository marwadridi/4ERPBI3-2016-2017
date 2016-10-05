package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;

import javax.enterprise.context.Destroyed;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="d_type")
public class Employe implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;
	/*
	// unidirectionnelle one to one 
	@OneToOne
	private Contact contact;
	// unidirectionnelle  many to one 
	
	@ManyToOne
	private Laboratoire laboratoire;
*/
	
	// association one to one bidirectionnelle :
	
	@OneToOne (cascade=CascadeType.PERSIST)
	private Contact contact;
	
	@ManyToOne
	private Laboratoire laboratoire;
	
	
	public Employe() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
//	public Laboratoire getLaboratoire() {
//		return laboratoire;
//	}
//	public void setLaboratoire(Laboratoire laboratoire) {
//		this.laboratoire = laboratoire;
//	}
   
}
