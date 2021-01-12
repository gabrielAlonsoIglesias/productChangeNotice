package com.poc.repository;

import java.util.List;

import com.poc.entity.Observable;
import com.poc.exception.RepositoryException;

/**
 * @author Gabriel 
 */
public interface ObservableRepository {

	public List<Observable> findAll() throws RepositoryException;

	public void insert(Observable observable) throws RepositoryException;
	
	public void delete(Observable observable) throws RepositoryException;

}
