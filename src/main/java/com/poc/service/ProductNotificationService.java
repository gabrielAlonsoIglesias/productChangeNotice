package com.poc.service;

import java.util.List;

import com.poc.domain.Message;
import com.poc.entity.ChangeEventEntity;
import com.poc.exception.ServiceException;


/**
 * @author
 */
public interface ProductNotificationService {

	public List<String> getCustomerNotifications(Integer customerId) throws ServiceException;

	public void addChangeEvent(Integer observerId, Message message) throws ServiceException;

	public void clearCustomerNotifications(ChangeEventEntity changeEventEntity) throws ServiceException;

}
