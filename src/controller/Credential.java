package controller;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@ApplicationScoped //TODO: Tratar de hacer con RequestScoped
public class Credential  implements Serializable{

    

    /**
	 * 
	 */
	private static final long serialVersionUID = 2969121345709412792L;

	private String email;

    private String password;
    private String newPsw;    

    private String repeatedPsw;

    private String confirmationPsw;
    

   

	public String getConfirmationPsw() {
		return confirmationPsw;
	}

	public void setConfirmationPsw(String confirmationPsw) {
		this.confirmationPsw = confirmationPsw;
	}

	public String getRepeatedPsw() {
		return repeatedPsw;
	}

	public void setRepeatedPsw(String repeatedPsw) {
		this.repeatedPsw = repeatedPsw;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
    

    public String getEmail() { return email; }

    public void setEmail(String email) { 
    	this.email = email; 
    	}

    

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    

}
