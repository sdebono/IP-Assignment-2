<%@tag description="Displays a link to log in/out for users"
	pageEncoding="UTF-8"%>

<jsp:useBean id="user" class="com.ip.assign2.Beans.UserBean"
	scope="session" />

<% if(user.isLoggedIn()) { %>
	<a href="${pageContext.request.contextPath}/account/logout_handler">Log Out</a>
<% 
     } else {
 %>
 	<a href="${pageContext.request.contextPath}/account/login.jsp">Log In</a>
 <% 
     }
 %>