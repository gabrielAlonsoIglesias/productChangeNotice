package com.pc.repository;

import java.util.List;

import com.pc.entity.ChangeEventEntity;
import com.pc.exception.RepositoryException;

/**
 * @author 
 */
public interface ChangeEventRepository {

	public List<ChangeEventEntity> getChangeEvents(Integer customerId) throws RepositoryException;
	
	public void insert(ChangeEventEntity changeEventEntity) throws RepositoryException;

	public void delete(ChangeEventEntity changeEventEntity) throws RepositoryException;

}
