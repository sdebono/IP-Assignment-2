<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base_page>
	<jsp:attribute name="head">
		<link href="${pageContext.request.contextPath}/res/css/NewItem.css" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:attribute name="content_header">
		
	</jsp:attribute>
	
	<jsp:attribute name="content_submenu">
		
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
			
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		
	</jsp:attribute>
	
	<jsp:body>
		<div style="padding-left: 50px;">
			<ul>
				<li>Only available if logged in</li>
				<li>Form to take in item details (name, reserve price, description, vendor etc)</li>
				<li>Checkbox group to select which category</li>
				<li>
					Servet:
					<ul style="padding-left: 20px;">
						<li>Check if entered details are valid (time > current, all fields filled out etc)</li>
						<li>Redirect to 'success' page, with link to item entry</li>
					</ul>
				</li>
			</ul>
		</div>
	</jsp:body>
</t:base_page>


