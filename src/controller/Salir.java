package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Salir implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7752812768448316512L;
	@ManagedProperty(value="#{login}")
	private Login login;
	private boolean loggedOut;
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Salir(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
	}
	@PostConstruct
	public void init() {
		login.logout();
		loggedOut=true;
	}

	public boolean isLoggedOut() {
		return loggedOut;
	}

	public void setLoggedOut(boolean loggedOut) {
		this.loggedOut = loggedOut;
	}
	

}
