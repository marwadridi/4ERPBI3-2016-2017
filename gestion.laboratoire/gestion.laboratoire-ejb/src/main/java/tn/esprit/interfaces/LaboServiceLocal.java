package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.persistance.Laboratoire;

@Local
public interface LaboServiceLocal {
	
	
	void addOrUpdateLabo(Laboratoire labo);
	void deleteLabo(Laboratoire laboratoire);
	Laboratoire findLabo(int id);
	List<Laboratoire> findAllLabos();

}
