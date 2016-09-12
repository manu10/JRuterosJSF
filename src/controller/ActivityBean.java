package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import helpers.FactoryDAO;
import model.Activity;

@ManagedBean
@ViewScoped
public class ActivityBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Activity activity = new Activity();
	private List<Activity> activityList;

	public ActivityBean() {
		setActivityList(FactoryDAO.getActivityDAO().getAll());
		//TODO validacion de acceso solo para admins
		//TODO validacion de trails antes de eliminar
	}

	public String createActivity() {
		activity.setIsEnable(true);
		FactoryDAO.getActivityDAO().create(activity);
		return "exito";
	}

	public String updateActivity(String index) {
		Activity act = activityList.get(Integer.parseInt(index));
		FactoryDAO.getActivityDAO().update(act);
		return "exito";
	}

	public String deleteActivity(String index) {
		Activity act = activityList.get(Integer.parseInt(index));
		FactoryDAO.getActivityDAO().delete(act);
		return "exito";
	}

	public String deshabilitar(String index) {
		Activity act = activityList.get(Integer.parseInt(index));
		act.setIsEnable(false);
		FactoryDAO.getActivityDAO().update(act);
		return "exito";

	}

	public String habilitar(String index) {
		Activity act = activityList.get(Integer.parseInt(index));
		act.setIsEnable(true);
		FactoryDAO.getActivityDAO().update(act);
		return "exito";

	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	// <!-- <li><h:commandLink
	// action="#{activityBean.loadActivities}">Actividades</h:commandLink></li>
	// -->
	// public String loadActivities() {
	// setActivityList(FactoryDAO.getActivityDAO().getAll());
	// return "showActivities";
	// }
}
