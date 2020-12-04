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
		<script src="${pageContext.request.contextPath}/jquery/i18n/datepicker.js"></script>
		<script src="${pageContext.request.contextPath}/jquery/jquery.displaytag-ajax-1.2.js"></script>
		<script src="${pageContext.request.contextPath}/jquery/jquery.maskedinput.js" /></script>

	</head>

	<body>
		<h1>Welcome to Change Product page</h1>
		<div class="pagePortal">
			<form:form id="changeProductSpecForm" action="changeProductSpec" method="POST" modelAttribute="formModel">
				<div>
					<label class="label" for="productId">Product Id</label>
					<input 	id="productId"
							type ="text"
							name="productId"
				 			autocomplete="off"/>
				 	<input id="changeProduct" class="button" type="submit" value="Change"/>				
				</div>
			</form:form>
		</div>          

	</body>

</html>