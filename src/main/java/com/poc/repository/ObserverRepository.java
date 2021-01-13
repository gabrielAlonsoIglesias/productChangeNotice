package com.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.entity.ObservableEntity;
import com.poc.entity.Observer;
import com.poc.exception.RepositoryException;

/**
 * @author galonsoi
 */
public interface ObserverRepository  {
	
	public List<Observer> getObservers() throws RepositoryException;

	public void insertObserver(Observer observer) throws RepositoryException;

}
