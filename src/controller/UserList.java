package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import helpers.FactoryDAO;
import model.FinalUser;

@ManagedBean
@ApplicationScoped
public class UserList implements Serializable{
	private List<FinalUser> userList;

	public UserList(){
		setUserList(FactoryDAO.getFinalUserDAO().getAll());	
	}
	public String deshabilitar(String index) {
		FinalUser usr = userList.get(Integer.parseInt(index));
		if (usr.getIsEnable()){
			usr.setIsEnable(false);
			FactoryDAO.getFinalUserDAO().update(usr);
		}
		return "deshabilitado";

	}
	
	public String habilitar(String index) {
		FinalUser usr = userList.get(Integer.parseInt(index));
		if (!usr.getIsEnable()){
			usr.setIsEnable(true);
			FactoryDAO.getFinalUserDAO().update(usr);
		}
		return "habilitado";

	}
	public List<FinalUser> getUserList() {
		return userList;
	}

	public void setUserList(List<FinalUser> userList) {
		this.userList = userList;
	}

}
