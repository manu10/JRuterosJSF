package controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LogOuts implements Serializable{

	@ManagedProperty(value="#{login}")
	private Login login;
	
	private boolean loggedOut;
	
	public LogOuts(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		login.logout();
		loggedOut=true;
	}

	public void setlogin(Login log) {
		this.login= log;
	}


	public boolean isLoggedOut() {
		return loggedOut;
	}

	public void setLoggedOut(boolean loggedOut) {
		this.loggedOut = loggedOut;
	}

}
