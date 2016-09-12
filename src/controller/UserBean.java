package controller;

import java.security.SecureRandom;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import helpers.EmailUtils;
import helpers.FactoryDAO;
import model.FinalUser;

@ManagedBean
@RequestScoped
public class UserBean {
	private FinalUser usuario = new FinalUser();
	private String user_id;
	private String repeatedPsw;
	private boolean newPsw;
	private List<FinalUser> userList;
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	String randomString( int len ){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	public String crearUsuario(){
		if (FactoryDAO.getUserDAO().getUserByUserEmail(usuario.getEmail())==null){
			usuario.setPassword(randomString(8));
			usuario.setIsEnable(true);
			FactoryDAO.getFinalUserDAO().create(usuario);
			if (usuario.getEmail().equals("manugarcia010@gmail.com"))//TODO: Eliminar, es simplemente para probar
				EmailUtils.sendPsw(usuario);
			newPsw=true;

			return "exito";	
		}
		return "userExist";



		//CAMBIAR LOS DATOS DE LA PERSISTENCIA CON LOS DATOS DE LA BBDD
		//	#: N° de grupo (5 en nuestro caso)
		//	usuario: jyaa_sala_usr#
		//	clave: jyaa_sala_psw# 
		//	DB: jyaa_sala_db#
	}
	public String modificarDatos(){
		FactoryDAO.getFinalUserDAO().update(usuario);
		return "exito";	
	}
	public String deshabilitar() {
		if (user_id!=null)
			return "deshabilitado";
		return "exito";

	}
	public String habilitar() {
		return "habilitado";

	}
	public FinalUser getUsuario() {
		return usuario;
	}

	public void setUsuario(FinalUser usuario) {
		this.usuario = usuario;
	}

	public String getRepeatedPsw() {
		return repeatedPsw;
	}

	public void setRepeatedPsw(String repeatedPsw) {
		this.repeatedPsw = repeatedPsw;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	//
	//<!-- <li><h:commandLink action="#{userBean.loadUsers}">Usuarios</h:commandLink></li> -->
	public String loadUsers(){
		setUserList(FactoryDAO.getFinalUserDAO().getAll());
		return "showUser";
	}

	public List<FinalUser> getUserList() {
		return userList;
	}

	public void setUserList(List<FinalUser> userList) {
		this.userList = userList;
	}

	public boolean isNewPsw() {
		return newPsw;
	}

	public void setNewPsw(boolean newPsw) {
		this.newPsw = newPsw;
	}

}
