package com.poc.repository;

import java.util.List;

import com.poc.entity.Observer;
import com.poc.exception.RepositoryException;

/**
 * @author Gabriel 
 */
public interface ObserverRepository {
	
	public List<Observer> getObservers() throws RepositoryException;

	public void insertObserver(Observer observer) throws RepositoryException;

}
