package com.pc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pc.common.Constants;
import com.pc.domain.FormModel;
import com.pc.domain.Message;
import com.pc.observable.ProductObservable;


/**
 * @author
 */
@Controller("changeProductController")
public class ChangeProductController extends CoreController {

	private static final Log LOG = LogFactory.getLog(ChangeProductController.class);
	
	@RequestMapping("/changeProductController/init")
	public String initForm(ModelMap model,
			   			   HttpServletRequest request) {		

		model.addAttribute(Constants.FORM_MODEL, new FormModel());
		this.addAttributeToSession(request, Constants.FORM_MODEL, new FormModel());
		
		return Constants.CHANGE_PRODUCT_VIEW;
	}
	
	@RequestMapping("/changeProductController/changeProductSpec")
	public String changeProductSpec(HttpServletRequest request,
								    ModelMap model,
								  	@ModelAttribute(Constants.FORM_MODEL) FormModel formModel,
								  	BindingResult result) {		
		try {
			ProductObservable observable = (ProductObservable) super.getAttributeFromSession(request, Constants.PRODUCT_OBSERVABLES);

			if (observable != null) {
				observable.setChanged(new Message(formModel.getProductId(), getChangeDescription(formModel.getProductId())));	
			} else {
				LOG.info("changeProductSpec # No observers have been subscribe to change product events");
			}			
		} catch (Exception e) {
			LOG.error("changeProductSpec # ERROR. Cause: " + e);
		}			

		return Constants.CHANGE_PRODUCT_VIEW;
	}

	private String getChangeDescription(Integer productId) {
		StringBuilder message = new StringBuilder("Product Id ").append(productId)
															    .append(" has breaking news. ")
																.append("Please visit our catalogue for further details");
		return message.toString();
	}

	  
}
