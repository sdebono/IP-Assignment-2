<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="f" tagdir="/WEB-INF/tags/forms" %>

<t:base_page>
	<jsp:attribute name="head">
		
	</jsp:attribute>
	
	<jsp:attribute name="content_header">
		Registration
	</jsp:attribute>
	
	<jsp:attribute name="content_submenu">
		Sign up for a new account to place bids & sell items
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">

	</jsp:attribute>
	
	<jsp:attribute name="footer">
		
	</jsp:attribute>
	
	<jsp:body>
		<form name="register_form" method="post" action="${pageContext.request.contextPath}/account/registration_handler/" enctype="application/x-www-form-urlencoded">
			<f:user_registration_form />
			
			<t:error />
			
			<input type="submit" name="submit" value="Register" />
		</form>
	</jsp:body>
</t:base_page>


