package controller;


import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty; //for bean injection
import javax.faces.bean.SessionScoped;

import helpers.FactoryDAO;
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
	@ManagedProperty(value="#{credential}")
	private Credential credential;

	private User user;
	private boolean isAdmin; //TODO:arreglar esto!!!
	
	public Login(){
		
		
	}

	public Credential getCredential() {
		return credential;
	}



	public void setCredential(Credential credential) {
		this.credential = credential;
	}





	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String login() {
		String email = credential.getEmail();
		if (email!=null){
			user = FactoryDAO.getUserDAO().getUserByUserEmail(email);
			if (email.equals("admin@admin.com")){
				isAdmin=true;//TODO: MOdificar esto! Es solo para prueba
				FinalUser usuario= new FinalUser();
				//TODO:ELIMINAR!! Es para que comience con un usuario creado para probar el habilitar deshabilitar
				usuario.setPassword("2345ftuvbh");
				usuario.setIsEnable(false);
				usuario.setName("PEPITO");
				FactoryDAO.getFinalUserDAO().create(usuario);
			}
			return "successfulLogin";
		}
		return "unsuccessfulLogin";
		//	        
		//
		//	        List<User> results = FactoryDAO.getUserDAO().getUser(
		//	        		userDatabase.createQuery(
		//
		//	           "select u from User u where u.username=:username and u.password=:password")
		//
		//	           .setParameter("username", credentials.getUsername())
		//
		//	           .setParameter("password", credentials.getPassword())
		//
		//	           .getResultList();
		//
		//	        
		//
		//	        if ( !results.isEmpty() ) {
		//
		//	           user = results.get(0);
		//
		//	        }
		//


	}



	public String logout() {

		user = null;
		return "loggedOut";


	}



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
		if (credential.getConfirmationPsw().equals(user.getPassword())){
			String psw=credential.getNewPsw();
			if ((!psw.equals("")) && psw.equals(credential.getRepeatedPsw())){
				user.setPassword(psw);
			}
			if (user instanceof FinalUser)
				FactoryDAO.getFinalUserDAO().update((FinalUser)user);
			//		else if (user instanceof Admin)
			//			FactoryDAO.getAdminDAO().update((FinalUser)user);
			return "exito";	
		}
		return "fallo";
	}


}

