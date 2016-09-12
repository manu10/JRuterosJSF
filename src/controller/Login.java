package controller;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty; //for bean injection
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import helpers.FactoryDAO;
import helpers.SessionUtil;
import model.Admin;
import model.FinalUser;
import model.User;
@ManagedBean(name= "login")
@SessionScoped
public class Login implements Serializable{
	/*
	 * COMENTARIOS TODO: 
	 * ***Cuando se cierra la sesion, el header muestra mal porque se evalua primero que el cuerpo de la pagina
	 * Hay que ver como lo podemos solucionar.
	 * ***Ver para que solo aparezca un solo boton habillitar/deshabilitar 
	 * *** al crear un usuario con mail "admin@admin.com" cuando se hace el login crea un nuevo usuario y se pone 
	 * el atributo admin en true, lo que genera que el header muestre el menu desplegable correspondiente
	 * ***ES UNA MIERDA TODO ESTO!!!!
	 * 
	 */


	/**
	 * 
	 */
	private static final long serialVersionUID = 9006242568409334101L;

	private User user;
	private boolean isAdmin; //TODO:arreglar esto!!!
	private String email; 
	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPsw() {
		return psw;
	}





	public void setPsw(String psw) {
		this.psw = psw;
	}


	private String psw ;
	public Login(){


	}





	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String login() {
		user = FactoryDAO.getUserDAO().getUserByUserEmail(email);
		//TODO: MOdificar esto! Es solo para prueba
		if (email.equals("admin@admin.com")){
			isAdmin=true;
			FinalUser usuario= new FinalUser();
			//TODO:ELIMINAR!! Es para que comience con un usuario creado para probar el habilitar deshabilitar
			usuario.setPassword("2345ftuvbh");
			usuario.setIsEnable(false);
			usuario.setName("PEPITO");
			FactoryDAO.getFinalUserDAO().create(usuario);
		}
		if (user!=null){
		if (psw.equals(user.getPassword())){
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("username", user);
			return "successfulLogin";
			//		}
			//		//boolean valid = LoginDAO.validate(user, pwd);
			//		if (valid) {
			//			HttpSession session = SessionUtils.getSession();
			//			session.setAttribute("username", user);
			//			
			//			return "admin";
		} else {
			user = null;//TODO: NO Deberia ser necesario (ver logout)
			FacesContext.getCurrentInstance().addMessage(
					"loginForm:inputPassword",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Incorrect Passowrd",
							"Contraseña incorrecta, intente nuevamente"));
			return "unsuccessfulLogin";
		}
		}else{
			FacesContext.getCurrentInstance().addMessage(
					"loginForm:inputEmail",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Incorrect Username",
							"Por favor ingrese un email valido"));
			return "unsuccessfulLogin";
			
		}
		
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		user = null;//TODO: ARREGLAR Esto es para que no muestre el boton como que esta la sesion iniciada pero se debe controlar de otra manera 
		return "loggedOut";
		//	}
		//		
		//		if (email!=null){
		//			user = FactoryDAO.getUserDAO().getUserByUserEmail(email);
		//			//TODO: MOdificar esto! Es solo para prueba
		//			if (email.equals("admin@admin.com")){
		//				isAdmin=true;
		//				FinalUser usuario= new FinalUser();
		//				//TODO:ELIMINAR!! Es para que comience con un usuario creado para probar el habilitar deshabilitar
		//				usuario.setPassword("2345ftuvbh");
		//				usuario.setIsEnable(false);
		//				usuario.setName("PEPITO");
		//				FactoryDAO.getFinalUserDAO().create(usuario);
		//			}
		//			
		//			if (psw.equals(user.getPassword())){
		//				return "successfulLogin";
		//			}
		//		}
		//		return "unsuccessfulLogin";
}



//		public String logout() {
//
//			user = null;
//			return "loggedOut";
//
//
//		}



		public boolean isLoggedIn() {

			return user!=null;

		}



		User getCurrentUser() {

			return user;

		}



		public boolean isAdmin() {
			return isAdmin;
		}



		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}


		public String modificarDatos(){
			//		if (credential.getConfirmationPsw().equals(user.getPassword())){
			//			String psw=credential.getNewPsw();
			//			if ((!psw.equals("")) && psw.equals(credential.getRepeatedPsw())){
			//				user.setPassword(psw);
			//			}
			//			if (user instanceof FinalUser)
			//				FactoryDAO.getFinalUserDAO().update((FinalUser)user);
			//			//		else if (user instanceof Admin)
			//			//			FactoryDAO.getAdminDAO().update((FinalUser)user);
			//			return "exito";	
			//		}
			return "fallo";
		}


	}

