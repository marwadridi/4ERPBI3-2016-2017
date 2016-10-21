package tn.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "labo")
public class Laboratoire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7095925168125653137L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nomLabo")
	private String nom;
	private String adresse;

	@OneToMany(mappedBy = "laboratoire",fetch=FetchType.EAGER)
	private List<Employe> employes;

	public Laboratoire() {

	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Laboratoire [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", employes=" + employes + "]";
	}

}
