package edu.esprit.mb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Technicien;

@ManagedBean
@ViewScoped
public class SubscriptionBean implements Serializable {

	private Technicien technicien = new Technicien();

	private Contact contact= new Contact();
	//private String msg = "invalide";

	@EJB
	EmployeServiceLocal employeServiceLocal;

	public void doAddTechnicien() {
		
		technicien.setContact(contact);
		employeServiceLocal.ajouterEmploye(technicien);

	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}

}
