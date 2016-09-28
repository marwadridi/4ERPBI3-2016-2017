package tn.esprit.services;

import javax.ejb.Stateless;

@Stateless
public class HelloService implements HelloServiceLocal, HelloServiceRemote {

	@Override
	public String sayHello(String msg) {
		return msg;
	}

}
