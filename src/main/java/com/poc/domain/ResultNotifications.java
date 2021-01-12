package com.poc.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author
 */
public class ResultNotifications implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 10L;

	@JsonProperty("notifications")
	private List<String> notifications;

	public ResultNotifications() {
		super();
	}

	public ResultNotifications(List<String> notifications) {
		super();
		this.notifications = notifications;
	}

}