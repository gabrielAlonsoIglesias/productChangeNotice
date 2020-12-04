package com.pc.service;

import java.util.List;

import com.pc.domain.Message;
import com.pc.entity.ChangeEventEntity;
import com.pc.exception.ServiceException;


/**
 * @author
 */
public interface ProductNotificationService {

	public List<String> getCustomerNotifications(Integer customerId) throws ServiceException;

	public void addChangeEvent(Integer observerId, Message message) throws ServiceException;

	public void clearCustomerNotifications(ChangeEventEntity changeEventEntity) throws ServiceException;

}
