package firstClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.services.HelloServiceRemote;

public class HelloServiceTest {

	public static void main(String[] args) throws NamingException {
		
		String jndiName="firstEJB/HelloService!tn.esprit.services.HelloServiceRemote";
		Context context = new InitialContext();
		HelloServiceRemote proxy=(HelloServiceRemote) context.lookup(jndiName);
		System.out.println(proxy.sayHello("hello"));
	}

}
