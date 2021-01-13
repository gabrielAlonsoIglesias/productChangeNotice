package com.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.entity.ObservableEntity;
import com.poc.exception.RepositoryException;

/**
 * @author galonsoi
 */
public interface ObservableRepository extends MongoRepository<ObservableEntity, String> {
/*
	public List<ObservableEntity> findAll() throws RepositoryException;

	public void insert(ObservableEntity observable) throws RepositoryException;
	
	public void delete(ObservableEntity observable) throws RepositoryException;
*/
}
