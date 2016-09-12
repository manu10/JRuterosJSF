package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Activity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	private String name;
	private Boolean isEnable;

	/**
	 * 
	 * @element-type Trail
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

}