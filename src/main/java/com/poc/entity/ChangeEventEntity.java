package com.poc.entity;

import java.io.Serializable;
import java.util.Objects;

import com.poc.common.Constants;

/**
 * @author galonsoi
 */
public class ChangeEventEntity implements Serializable {

	private static final long serialVersionUID = 794572691569499322L;

	private Integer customerId;

	private String changeDescription;
	
	public ChangeEventEntity() {}

	public ChangeEventEntity(Integer customerId, String changeDescription) {
		super();

		this.customerId = customerId;
		this.changeDescription = changeDescription;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return new StringBuilder(Objects.toString(this.customerId)).append(Constants.HASH)
						                                           .append(Objects.toString(this.changeDescription)).toString();
	}

}
