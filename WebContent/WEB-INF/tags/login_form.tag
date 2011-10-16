<%@tag description="Displays a login form to the user" pageEncoding="UTF-8"%>

<table>
	<tr>
		<th>User Name:</th>
		<td><input type="text" name="username" value="<%= request.getAttribute("username") == null ? "" : request.getAttribute("username") %>"></td>
	</tr>
	<tr>
		<th>Password:</th>
		<td><input type="password" name="password" value="<%= request.getAttribute("password") == null ? "" : request.getAttribute("password") %>"></td>
	</tr>
</table>