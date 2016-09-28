package tn.esprit.services;

import javax.ejb.Remote;

@Remote
public interface TraducteurServiceRemote {
	
	String traduire(String mot);

}
