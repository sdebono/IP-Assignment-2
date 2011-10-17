<%@tag description="Displays a series of input forms to collect information about a new bid item" pageEncoding="UTF-8"%>

<table>
	<tr>
		<th>Item name:</th>
		<td><input type="text" name="username" value="<%= request.getAttribute("username") == null ? "" : request.getAttribute("username") %>"></td>
	</tr>
	<tr>
		<th>Item Brand:</th>
		<td><input type="password" name="password" value="<%= request.getAttribute("password") == null ? "" : request.getAttribute("password") %>"></td>
	</tr>
	<tr>
		<th>Item Description:</th>
		<td><input type="text" name="firstname" value="<%= request.getAttribute("firstname") == null ? "" : request.getAttribute("firstname") %>"></td>
	</tr>
	<tr>
		<th>Starting Time:</th>
		<td><input type="text" name="lastname" value="<%= request.getAttribute("lastname") == null ? "" : request.getAttribute("lastname") %>"></td>
	</tr>
	<tr>
		<th>Closing Time:</th>
		<td><input type="text" name="email" value="<%= request.getAttribute("email") == null ? "" : request.getAttribute("email") %>"></td>
	</tr>
	<tr>
		<th>Image URL:</th>
		<td><input type="text" name="phone" value="<%= request.getAttribute("phone") == null ? "" : request.getAttribute("phone") %>"></td>
	</tr>
	<tr>
		<th>Reserve Price:</th>
		<td><input type="text" name="creditcardnumber" value="<%= request.getAttribute("creditcardnumber") == null ? "" : request.getAttribute("creditcardnumber") %>"></td>
	</tr>
</table>