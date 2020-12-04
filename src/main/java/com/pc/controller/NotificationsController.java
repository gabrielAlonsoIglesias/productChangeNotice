package com.pc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pc.domain.ResultNotifications;
import com.pc.service.ProductNotificationService;


/**
 * @author
 */
@Controller("notificationsController")
public class NotificationsController extends CoreController {

	private static final Log LOG = LogFactory.getLog(NotificationsController.class);

	@Autowired
	private ProductNotificationService productNotificationService;

	@RequestMapping("/notificationsController/getNotifications")
	public ResponseEntity<ResultNotifications> getNotifications(HttpServletRequest request,
															   HttpServletResponse httpServletResponse,
															   @RequestParam("customerId") Integer customerId) {															   
		HttpHeaders headers = new HttpHeaders();
		List<String> notifications = new ArrayList<>();
		ResponseEntity<ResultNotifications> response = null;

		LOG.info("getNotifications # ENTER");

		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			notifications = this.productNotificationService.getCustomerNotifications(customerId);
			response = new ResponseEntity<>(new ResultNotifications(notifications), headers, HttpStatus.OK);
		} catch (Exception e) {

			LOG.error("getNotifications # ERROR. Causa: " + e);

			response = new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}

		LOG.info("getNotifications # EXIT");

		return response;

	}

}
