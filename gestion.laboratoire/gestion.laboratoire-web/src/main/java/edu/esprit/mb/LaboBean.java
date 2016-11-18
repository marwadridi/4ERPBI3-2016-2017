package edu.esprit.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.interfaces.LaboServiceLocal;
import tn.esprit.persistance.Laboratoire;

@ManagedBean
@ViewScoped
public class LaboBean {

	private List<Laboratoire> laboratoires = new ArrayList<Laboratoire>();
	private Laboratoire laboratoire;
	private Boolean displayForm;

	@EJB
	LaboServiceLocal service;

	@PostConstruct
	public void init() {
		laboratoire = new Laboratoire();
		laboratoires = service.findAllLabos();
	}

	public void doAddOrUpdate() {
		service.addOrUpdateLabo(laboratoire);
		setDisplayForm(false);
		init();

	}

	public void dodelete() {
		service.deleteLabo(laboratoire);
		setDisplayForm(false);
		init();
	}

	public void doCancel() {
		setDisplayForm(false);
	}

	public void doNew() {
		setDisplayForm(true);
		laboratoire=new Laboratoire();
	}

	public List<Laboratoire> getLaboratoires() {
		return laboratoires;
	}

	public void setLaboratoires(List<Laboratoire> laboratoires) {
		this.laboratoires = laboratoires;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public Boolean getDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(Boolean displayForm) {
		this.displayForm = displayForm;
	}

}
