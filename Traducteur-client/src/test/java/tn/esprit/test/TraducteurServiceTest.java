package tn.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.services.TraducteurServiceRemote;

public class TraducteurServiceTest {

	
	
	public static void main(String[] args) throws NamingException {
		
		
		String jndiName="Traducteur-ejb/TraducteurService"
				+ "!tn.esprit.services.TraducteurServiceRemote";
		
		Context context = new InitialContext();
		
		TraducteurServiceRemote proxy =(TraducteurServiceRemote) 
				    context.lookup(jndiName);
		
		
		
		

	}

}
