package com.poc.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author galonsoi
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private Integer observableId;
	
	private String changeDescription;
	
	public Message(Integer observableId, String changeDescription) {
		super();
		this.observableId = observableId;
		this.changeDescription = changeDescription;
	}

	public Integer getObservableId() {
		return observableId;
	}

	public void setObservableId(Integer observableId) {
		this.observableId = observableId;
	}

	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	@Override
	public String toString() {		
		return String.format("[Message] observableId=%s, changeDescription=%s", 
							 Objects.toString(this.observableId),
							 Objects.toString(this.changeDescription));
	}

}
