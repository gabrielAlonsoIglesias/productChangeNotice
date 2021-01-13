package com.poc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author galonsoi
 */
public class MongoDBEntity implements Serializable {

	private static final long serialVersionUID = 4108219830407766741L;

	@Id
	@Field("_id")
	protected String id;

	@Field("add_user")
	protected String addUser;
	
	@Field("add_date")
	protected LocalDateTime addDate;

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public LocalDateTime getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDateTime addDate) {
		this.addDate = addDate;
	}

}
