package com.poc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Gabriel
 */

public class Observable implements Serializable {

	private static final long serialVersionUID = 4108219830407766741L;

	private Integer observableId;

	private String name;
	
	private String addUser;
	
	private LocalDateTime addDate;

	public Observable() {}

	public Observable(Integer observableId, String name, String addUser, LocalDateTime addDate) {
		super();

		this.observableId = observableId;
		this.name = name;
		this.addUser = addUser;
		this.addDate = addDate;
	}

	/**
	 * @return the observableId
	 */
	public Integer getObservableId() {
		return observableId;
	}

	/**
	 * @param observableId the observableId to set
	 */
	public void setObservableId(Integer observableId) {
		this.observableId = observableId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addUser
	 */
	public String getAddUser() {
		return addUser;
	}

	/**
	 * @param addUser the addUser to set
	 */
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	/**
	 * @return the addDate
	 */
	public LocalDateTime getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(LocalDateTime addDate) {
		this.addDate = addDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Observable [observableId=%s, name=%s, addUser=%s, addDate=%s]", 
				   			 Objects.toString(this.observableId),
				   			 Objects.toString(this.name),
				   			 Objects.toString(this.addUser),
				   			 Objects.toString(this.addDate));
	}

}
