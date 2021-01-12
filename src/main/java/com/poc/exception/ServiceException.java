package com.poc.exception;

/**
 * @author 
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -163849694885464773L;

	public ServiceException(String messsage) {
		super(messsage);
	}
	
	public ServiceException(Throwable throwable) {
		super(throwable);
	}

	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
