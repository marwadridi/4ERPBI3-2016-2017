package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.persistance.Test;

@Remote
public interface TestServiceRemote {
	
	void ajouterTest(Test test);

}
