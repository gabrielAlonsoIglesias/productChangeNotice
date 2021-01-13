package com.poc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.adapter.ChangeEventAdapter;
import com.poc.domain.Message;
import com.poc.entity.ChangeEventEntity;
import com.poc.exception.RepositoryException;
import com.poc.exception.ServiceException;
import com.poc.repository.ChangeEventRepository;
import com.poc.service.ProductNotificationService;


/**
 * @author galonsoi
 */
@Service("productNotificationService")
public class ProductNotificationServiceImpl implements ProductNotificationService {

	@Autowired
	private ChangeEventRepository changeEventRepository;

	@Autowired
	private ChangeEventAdapter changeEventAdapter;

	@Override
	public List<String> getCustomerNotifications(Integer customerId) throws ServiceException {
		List<String> notifications = new ArrayList<>();
		try {
			List<ChangeEventEntity> changeEvents = this.changeEventRepository.getChangeEvents(customerId);

			for (ChangeEventEntity changeEventEntity : changeEvents) {
				notifications.add(changeEventEntity.getChangeDescription());
			}
		} catch (Exception e) {
			throw new ServiceException(e);		
		}
		return notifications;
	}

	@Override
	public void addChangeEvent(Integer observerId, Message message) throws ServiceException {
		try {
			this.changeEventRepository.insert(this.changeEventAdapter.toEntity(observerId, message));
		} catch (RepositoryException e) {
			throw new ServiceException(e);		
		}
	}

	@Override
	public void clearCustomerNotifications(ChangeEventEntity changeEventEntity) throws ServiceException {
		try {
			this.changeEventRepository.delete(changeEventEntity);
		} catch (RepositoryException e) {
			throw new ServiceException(e);		
		}
	}

}
