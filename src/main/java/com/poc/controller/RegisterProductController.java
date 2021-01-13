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
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.common.Constants;
import com.poc.domain.FormModel;
import com.poc.observable.ProductObservable;
import com.poc.observer.CustomerObserver;
import com.poc.service.ProductNotificationService;


/**
 * @author galonsoi
 */
@Controller("registerProductController")
public class RegisterProductController extends CoreController {

	private static final Log LOG = LogFactory.getLog(RegisterProductController.class);

	@Autowired
	private ProductNotificationService productNotificationService;

	@RequestMapping("/registerProductController/init")
	public String initForm(ModelMap model,
						   HttpServletRequest request,
						   @RequestParam(Constants.CUSTOMER_ID) String customerId) {

		super.addAttributeToSession(request, Constants.CUSTOMER_ID, customerId);
		super.addAttributeToSession(request, Constants.FORM_MODEL, new FormModel());
		model.addAttribute(Constants.FORM_MODEL, new FormModel());

		return Constants.SCAN_PRODUCT_VIEW;
	}

	@RequestMapping("/registerProductController/scan")
	public String scanProduct(HttpServletRequest request,
							  ModelMap model,
							  @ModelAttribute(Constants.FORM_MODEL) FormModel formModel,
							  BindingResult result) {
		try {
			Integer customerId = Integer.parseInt((String) super.getAttributeFromSession(request, Constants.CUSTOMER_ID));

			ProductObservable productObservable = addCustomerObserver(request, customerId, formModel.getProductId());

			this.addAttributeToSession(request, Constants.PRODUCT_OBSERVABLES, productObservable);	
		} catch (Exception e) {
			LOG.error("scanProduct # ERROR. Cause: " + e);
		}

		return Constants.SCAN_PRODUCT_VIEW;
	}

	private ProductObservable addCustomerObserver(HttpServletRequest request, Integer customerId, Integer productId) {
		ProductObservable productObservable = (ProductObservable) super.getAttributeFromSession(request, Constants.PRODUCT_OBSERVABLES);

		if (productObservable == null) {
			productObservable = new ProductObservable();
		}

		productObservable.addObserver(new CustomerObserver(this.productNotificationService, customerId, productId));

		LOG.info("addCustomerObserver # Count observers: " + productObservable.countObservers());

		return productObservable;
	}

}
