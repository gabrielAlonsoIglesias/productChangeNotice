
package com.poc.adapter;

import org.springframework.stereotype.Component;

import com.poc.domain.Message;
import com.poc.entity.ChangeEventEntity;

/**
 * @author galonsoi
 */
@Component("changeEventAdapter")
public class ChangeEventAdapter {

    public ChangeEventEntity toEntity(final Integer observerId, final Message message) {
    	ChangeEventEntity changeEventEntity = new ChangeEventEntity();

        if (message != null) {
        	changeEventEntity.setCustomerId(observerId);
        	changeEventEntity.setChangeDescription(message.getChangeDescription());
        }

        return changeEventEntity;
    }

}
