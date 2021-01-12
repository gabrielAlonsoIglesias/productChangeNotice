package com.poc.controller;


import javax.servlet.http.HttpServletRequest;

public abstract class CoreController {

	public Object getAttributeFromRequest(HttpServletRequest request, String nameAttr) {
		return request.getAttribute(nameAttr);
	}

	public void addAttributeToRequest(HttpServletRequest request, String nameAttr, Object value) {
		request.setAttribute(nameAttr, value);
	}

	public Object getAttributeFromSession(HttpServletRequest request, String nameAttr) {
		return request.getSession(true).getAttribute(nameAttr);
	}

	public void addAttributeToSession(HttpServletRequest request, String nameAttr, Object value) {
		request.getSession(true).setAttribute(nameAttr, value);
	}

}
