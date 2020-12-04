package com.pc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.adapter.ChangeEventAdapter;
import com.pc.domain.Message;
import com.pc.entity.ChangeEventEntity;
import com.pc.exception.RepositoryException;
import com.pc.exception.ServiceException;
import com.pc.repository.ChangeEventRepository;
import com.pc.service.ProductNotificationService;


/**
 * @author
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
