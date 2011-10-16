<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="f" tagdir="/WEB-INF/tags/forms" %>

<t:base_page>
	<jsp:attribute name="header">
		
	</jsp:attribute>
	
	<jsp:attribute name="head">
		
	</jsp:attribute>
	
	<jsp:attribute name="content_header">
		Login
	</jsp:attribute>
	
	<jsp:attribute name="content_submenu">
		Please enter your details
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">

	</jsp:attribute>
	
	<jsp:attribute name="footer">
		
	</jsp:attribute>
	
	<jsp:body>
		<form name="register_form" method="post" action="${pageContext.request.contextPath}/account/login_handler/" enctype="application/x-www-form-urlencoded">
			<f:login_form />
			<br />
			<input type="submit" name="submit" value="Login" class="grey_button"/>
		</form>
	</jsp:body>
</t:base_page>


