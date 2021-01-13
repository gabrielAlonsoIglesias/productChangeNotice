package com.poc.observer;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.poc.domain.Message;
import com.poc.service.ProductNotificationService;

/**
 * @author galonsoi
 */
public class CustomerObserver implements Observer {

	private static final Log LOG = LogFactory.getLog(CustomerObserver.class);

	private ProductNotificationService productNotificationService;

	private Integer customerId;

	private Integer productId;

    public CustomerObserver(ProductNotificationService productSubscriptionRepository, Integer customerId, Integer productId) {
    	this.productNotificationService = productSubscriptionRepository;
    	this.customerId = customerId;
    	this.productId = productId;
    }

    @Override
    public void update(Observable observable, Object object) {

    	Message message = (Message) object;

    	LOG.info("update # I am the observer with Customer Id: " + this.customerId + "; product Id: "  + this.productId + "; message: " + message.toString());

    	if (isSubscribedToOberservable(message)) {

    		LOG.info("update # Register change event");

    		saveChangeEvent(message);
    	}
    }

    private Boolean isSubscribedToOberservable(Message message) { 
  		 return (this.productId != null && this.productId.equals(message.getObservableId()));
    }

	private void saveChangeEvent(Message message) {
   		try {
   			this.productNotificationService.addChangeEvent(this.customerId, message);
   		} catch (Exception e) {
   			LOG.error("update # ERROR. Cause: " + e);
   		}
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomerObserver other = (CustomerObserver) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!productId.equals(other.productId)) {
			return false;
		}
		return true;
	}

}
