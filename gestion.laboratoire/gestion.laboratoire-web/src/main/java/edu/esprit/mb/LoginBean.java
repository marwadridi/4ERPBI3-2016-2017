package edu.esprit.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.persistance.Chercheur;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Technicien;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	private Employe employe;
	private boolean loggedIn;

	// injection de dépendances

	@EJB
	EmployeServiceLocal employeServiceLocal;

	public String doLogin() {

		String navigateTo = "";

		employe = employeServiceLocal.identifierEmploye(login, password);

		if (employe != null) {
			if (employe instanceof Chercheur) {
				navigateTo = "/pages/chercheur/welcome?faces-redirect=true";
				setLoggedIn(true);
			}

			if (employe instanceof Technicien) {
				navigateTo = "/pages/technicien/welcome";
				setLoggedIn(true);
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credantials"));
			navigateTo = "null";
		}
		return navigateTo;
	}

	public String doLogout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
