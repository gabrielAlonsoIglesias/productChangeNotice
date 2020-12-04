<!doctype html>

<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<html>

	<head>

		<title>Notifications Subscriptions Products Page</title>
            
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui.css" />

		<script src="${pageContext.request.contextPath}/jquery/jquery-1.8.2.js"></script>
		<script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
		<script src="${pageContext.request.contextPath}/jquery/jquery.displaytag-ajax-1.2.js"></script>
		<script src="${pageContext.request.contextPath}/jquery/jquery.maskedinput.js" /></script>

        <script>
        
        	function isNull(value) {
        		return (   $.trim(value).length <= 0
            			|| $.trim(value) == null
            			|| $.trim(value) == "");
        	}

        	function showNotifications() {
            	$("#notifications").effect("blind", {mode:"show", direction:"horizontal"}, 2000);
        	}

        	function hideNotifications() {
        		// Close notifications after 10 (10000) seconds
				setTimeout(function() {
					$("#notifications").hide('blind', {}, 500)
			    }, 10000);
        	}

        	function getNotifications() {
				// Clears the table
				$("#notifications").children("ul li").remove();

				var customerId = '<%= session.getAttribute("customerId") %>';

//				if (!isNull(customerId)) {
//				alert("customerId: " + customerId);

				$.ajax({
					type       : "POST",
				    url        : "${pageContext.request.contextPath}/web/notificationsController/getNotifications",
				    data       : {customerId: customerId},
				 	dataType   : "json",
				 	error      : function(xhr, status, error) { 		
				 		alert("error");
					},
					success    : function(results, status, xhr) {

//						alert("length: " + results.notifications.length);

						if (results.notifications.length > 0) {

							var notifications = results.notifications;

							for (var i = 0; i < results.notifications.length; i++) {

//								alert("notification: " + notifications[i]);

			      				var row = "<li class='info'>" + notifications[i] + "</li>";
		      		 		 	$(row).appendTo("#notifications");
							}
							showNotifications();
						}
						// Fire a delay close notifications event
//						hideNotifications();
					},
					complete   : function(xhr, status) {}
				});
        	}

			$(document).ready(function() {
/*
				$("#send").on("click", function() {
					getNotifications();
				});
*/


				function requestNotifications() {

//				    alert("")

					getNotifications();
					// Each 15 seconds (15000)
				    setTimeout(requestNotifications, 15000);
				}
				requestNotifications();	 

			});
		</script>
	</head>

	<body>
		<!-- Notifications area -->
		<ul id="notifications"></ul>

		<h1>Welcome to Product Catalogue page. Customer <%= session.getAttribute("customerId") %></h1>		
		<div class="pagePortal">
			<form:form id="scanProductSpecForm" action="scan" method="POST" modelAttribute="formModel" >				
				<div>
					<label class="label" for="productId">Product Id</label>
					<input 	id="productId"
							type ="text"
							name="productId"
				 			autocomplete="off"/>
				 	<input id="scan" class="button" type="submit" value="Scan"/>				
				</div>
				<!-- 
				<input id="send" class="button" type="button" value="Send"/>
				 -->
			</form:form>
		</div>
	</body>

</html>