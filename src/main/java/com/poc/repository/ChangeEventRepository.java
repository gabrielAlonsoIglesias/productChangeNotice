package com.poc.repository;

import java.util.List;

import com.poc.entity.ChangeEventEntity;
import com.poc.exception.RepositoryException;

/**
 * @author galonsoi
 */
public interface ChangeEventRepository {

	public List<ChangeEventEntity> getChangeEvents(Integer customerId) throws RepositoryException;
	
	public void insert(ChangeEventEntity changeEventEntity) throws RepositoryException;

	public void delete(ChangeEventEntity changeEventEntity) throws RepositoryException;

}
