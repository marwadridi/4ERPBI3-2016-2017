package tn.esprit.persistance;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Chercheur
 *
 */
@Entity
public class Chercheur extends Employe implements Serializable {

	private String grade;
	private static final long serialVersionUID = 1L;

	public Chercheur() {
		super();
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
