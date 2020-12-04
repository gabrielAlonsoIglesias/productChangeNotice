
package com.pc.adapter;

import org.springframework.stereotype.Component;

import com.pc.domain.Message;
import com.pc.entity.ChangeEventEntity;

/**
 * @author
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
