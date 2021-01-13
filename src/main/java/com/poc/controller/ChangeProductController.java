package com.poc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poc.common.Constants;
import com.poc.domain.FormModel;
import com.poc.domain.Message;
import com.poc.entity.ObservableEntity;
import com.poc.observable.ProductObservable;
import com.poc.repository.ObservableRepository;
import com.poc.util.DateUtils;


/**
 * @author galonsoi
 */
@Controller("changeProductController")
public class ChangeProductController extends CoreController {

	private static final Log LOG = LogFactory.getLog(ChangeProductController.class);
	
	@Autowired
	private ObservableRepository observableRepository;
	
	@Autowired
	private DateUtils dateUtils;

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

			this.observableRepository.insert(new ObservableEntity(formModel.getProductId(), "Gabriel", "galonsoi", this.dateUtils.getCurrentLocalDateTime()));

			
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
