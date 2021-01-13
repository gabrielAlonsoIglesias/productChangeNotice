package com.poc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author galonsoi
 */
public class Observer implements Serializable {

	private static final long serialVersionUID = 794572691569499322L;

	private Integer observerId;
	
	private Integer observableId;

	private String description;
	
	private String addUser;
	
	private LocalDateTime addDate;

	public Observer() {}

	public Observer(Integer observerId, Integer observableId, String description, String addUser, LocalDateTime addDate) {
		super();

		this.observerId = observerId;
		this.observableId = observableId;
		this.description = description;
		this.addUser = addUser;
		this.addDate = addDate;
	}

	/**
	 * @return the observerId
	 */
	public Integer getObserverId() {
		return observerId;
	}

	/**
	 * @param observerId the observerId to set
	 */
	public void setObserverId(Integer observerId) {
		this.observerId = observerId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		return String.format("Observer [observerId=%s, observableId=%s, description=%s, addUser=%s, addDate=%s]", 
				   			 Objects.toString(observerId),
				   			 Objects.toString(observableId),
				   			 Objects.toString(description),
				   			 Objects.toString(addUser),
				   			 Objects.toString(addDate));
	}

}
