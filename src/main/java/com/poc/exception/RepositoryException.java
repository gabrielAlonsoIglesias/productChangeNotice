package com.poc.exception;

/**
 * @author 
 */
public class RepositoryException extends Exception {

	private static final long serialVersionUID = -163849694885464773L;

	public RepositoryException(String messsage) {
		super(messsage);
	}
	
	public RepositoryException(Throwable throwable) {
		super(throwable);
	}

	public RepositoryException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
