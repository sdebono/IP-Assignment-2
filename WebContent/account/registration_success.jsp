<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base_page>
	<jsp:attribute name="head">
		
	</jsp:attribute>
	
	<jsp:attribute name="content_header">
		Success!
	</jsp:attribute>
	
	<jsp:attribute name="content_submenu">
		Your registration has been successfully processed
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
	
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		
	</jsp:attribute>
	
	<jsp:body>
		<p class="single_message"> 
			Please click <a href="${pageContext.request.contextPath}/index.jsp">here</a> to continue 
		</p>
	</jsp:body>
</t:base_page>


