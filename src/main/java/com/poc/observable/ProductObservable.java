package com.poc.observable;

import java.util.Observable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.poc.domain.Message;

/**
 * @author
 */
public class ProductObservable extends Observable {

	private static final Log LOG = LogFactory.getLog(ProductObservable.class);

	public ProductObservable() {
		super();
	}

	public void setChanged(Message message) {

    	LOG.info("setUpdate # Message: " + message.toString());

    	setChanged();
    	notifyObservers(message);
	}

}
