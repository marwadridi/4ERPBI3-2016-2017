package tn.esprit.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class DictionnaireService
 */
@Singleton
@LocalBean
public class DictionnaireService {
	private Map<String, String> dict;

	public DictionnaireService() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init (){
		
		dict = new HashMap<>();
		dict.put("salut", "hello");
		dict.put("bonjour", "good morning");
		
	
		
	}
	
	

	

	public Map<String, String> getDict() {
		return dict;
	}

	public void setDict(Map<String, String> dict) {
		this.dict = dict;
	}
	

}
