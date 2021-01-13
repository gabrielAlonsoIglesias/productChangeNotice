package com.poc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author galonsoi
 */
@Document(collection = "observables")
public class ObservableEntity extends MongoDBEntity {

	private static final long serialVersionUID = 4108219830407766741L;

	private Integer observableId;

	private String name;
	
	public ObservableEntity() {}

	public ObservableEntity(Integer observableId, String name, String addUser, LocalDateTime addDate) {
		super();

		this.observableId = observableId;
		this.name = name;
		this.addUser = addUser;
		this.addDate = addDate;
	}

	public Integer getObservableId() {
		return this.observableId;
	}

	public void setObservableId(Integer observableId) {
		this.observableId = observableId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ObservableEntity [id=%s, observableId=%s, name=%s, addUser=%s, addDate=%s]", 
							 Objects.toString(this.id),
							 Objects.toString(this.observableId),
				   			 Objects.toString(this.name),
				   			 Objects.toString(this.addUser),
				   			 Objects.toString(this.addDate));
	}

}
