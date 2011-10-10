<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base_page>
	<jsp:attribute name="header">
		
	</jsp:attribute>
	
	<jsp:attribute name="head">
		head
	</jsp:attribute>
	
	<jsp:attribute name="content_header">
		content head
	</jsp:attribute>
	
	<jsp:attribute name="content_submenu">
		content submenu
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		sidebar	
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		footer
	</jsp:attribute>
	
	<jsp:body>
		<form name="register_form" method="post" action="${pageContext.request.contextPath}/account/registration_handler/" enctype="application/x-www-form-urlencoded">
			<t:user_registration_form />
			
			<input type="submit" name="submit" value="Register" />
		</form>
	</jsp:body>
</t:base_page>


