<%@tag description="Base Template Tag" pageEncoding="UTF-8"%>

<% if(request.getAttribute("is_error") != null && ((Boolean)request.getAttribute("is_error")))  {%>
	<p class="error_message"><jsp:doBody /></p>
<% } %>
