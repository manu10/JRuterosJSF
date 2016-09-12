package controller;

import java.security.SecureRandom;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import helpers.FactoryDAO;
import model.FinalUser;
import model.Trail;

@ManagedBean
@RequestScoped
public class TrailBean {
private Trail trail= new Trail();


public String newTrail(){
//	
//	usuario.setPassword(randomString(8));
//	usuario.setIsEnable(true);
//	FactoryDAO.getFinalUserDAO().create(usuario);
////	setUserList(FactoryDAO.getFinalUserDAO().getAll());	
//	newPsw=true;
	return "exito";	

	//CAMBIAR LOS DATOS DE LA PERSISTENCIA CON LOS DATOS DE LA BBDD
//	#: N° de grupo (5 en nuestro caso)
//	usuario: jyaa_sala_usr#
//	clave: jyaa_sala_psw# 
//	DB: jyaa_sala_db#
}
//public String modificarDatos(){
//	FactoryDAO.getFinalUserDAO().update(usuario);
//	return "exito";	
//}
//public String deshabilitar() {
//	if (user_id!=null)
//		return "deshabilitado";
//	return "exito";
//	
//}
//public String habilitar() {
//	return "habilitado";
//	
//}
//public FinalUser getUsuario() {
//	return usuario;
//}
//
//public void setUsuario(FinalUser usuario) {
//	this.usuario = usuario;
//}
//
//public String getRepeatedPsw() {
//	return repeatedPsw;
//}
//
//public void setRepeatedPsw(String repeatedPsw) {
//	this.repeatedPsw = repeatedPsw;
//}
//
//public String getUser_id() {
//	return user_id;
//}
//
//public void setUser_id(String user_id) {
//	this.user_id = user_id;
//}
//
////
////<!-- <li><h:commandLink action="#{userBean.loadUsers}">Usuarios</h:commandLink></li> -->
//public String loadUsers(){
//	setUserList(FactoryDAO.getFinalUserDAO().getAll());
//	return "showUser";
//}
//
//public List<FinalUser> getUserList() {
//	return userList;
//}
//
//public void setUserList(List<FinalUser> userList) {
//	this.userList = userList;
//}
//
//public boolean isNewPsw() {
//	return newPsw;
//}
//
//public void setNewPsw(boolean newPsw) {
//	this.newPsw = newPsw;
//}
// 


public Trail getTrail() {
	return trail;
}


public void setTrail(Trail trail) {
	this.trail = trail;
}
}
