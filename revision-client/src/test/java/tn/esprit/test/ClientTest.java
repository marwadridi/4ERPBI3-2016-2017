package tn.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.persistance.Test;
import tn.esprit.services.TestServiceRemote;

public class ClientTest {

	public static void main(String[] args) throws NamingException {
		
		String jndiName="revision-ear/revision-ejb/TestService"
				+ "!tn.esprit.services.TestServiceRemote";
		Context context=new InitialContext();
		TestServiceRemote proxy=(TestServiceRemote) 
				context.lookup(jndiName);

			Test testpersistance = new Test();
			testpersistance.setId(1);
			proxy.ajouterTest(testpersistance);
	
	
	}

}
