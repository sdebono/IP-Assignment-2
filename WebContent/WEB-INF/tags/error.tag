<%@tag description="Base Template Tag" pageEncoding="UTF-8"%>
<%@attribute name="error_message" fragment="true" %>

<% if(request.getAttribute("is_error") != null && ((Boolean)request.getAttribute("is_error")))  {%>
	<p class="error_message">
		<%= request.getAttribute("error_message") %>
		
		<!-- Needed for tag to compile, but not used -->
		<jsp:doBody/>
	</p>
<% } %>
