<%@tag description="Displays a series of input forms to collect user details" pageEncoding="UTF-8"%>

<table>
	<tr>
		<th>User Name:</th>
		<td><input type="text" name="username" value="<%= request.getAttribute("username") == null ? "" : request.getAttribute("username") %>"></td>
	</tr>
	<tr>
		<th>Password:</th>
		<td><input type="password" name="password" value="<%= request.getAttribute("password") == null ? "" : request.getAttribute("password") %>"></td>
	</tr>
	<tr>
		<th>First Name:</th>
		<td><input type="text" name="firstname" value="<%= request.getAttribute("firstname") == null ? "" : request.getAttribute("firstname") %>"></td>
	</tr>
	<tr>
		<th>Last Name:</th>
		<td><input type="text" name="lastname" value="<%= request.getAttribute("lastname") == null ? "" : request.getAttribute("lastname") %>"></td>
	</tr>
	<tr>
		<th>Email:</th>
		<td><input type="text" name="email" value="<%= request.getAttribute("email") == null ? "" : request.getAttribute("email") %>"></td>
	</tr>
	<tr>
		<th>Phone:</th>
		<td><input type="text" name="phone" value="<%= request.getAttribute("phone") == null ? "" : request.getAttribute("phone") %>"></td>
	</tr>
	<tr>
		<th>Credit Card Number:</th>
		<td><input type="text" name="creditcardnumber" value="<%= request.getAttribute("creditcardnumber") == null ? "" : request.getAttribute("creditcardnumber") %>"></td>
	</tr>
	<tr>
		<th>Address Number:</th>
		<td><input type="text" name="addressnumber" value="<%= request.getAttribute("addressnumber") == null ? "" : request.getAttribute("addressnumber") %>"></td>
	</tr>
	<tr>
		<th>Address Street:</th>
		<td><input type="text" name="addressstreet" value="<%= request.getAttribute("addressstreet") == null ? "" : request.getAttribute("addressstreet") %>"></td>
	</tr>
	<tr>
		<th>Address Suburb:</th>
		<td><input type="text" name="addresssuburb" value="<%= request.getAttribute("addresssuburb") == null ? "" : request.getAttribute("addresssuburb") %>"></td>
	</tr>
	<tr>
		<th>Address Postcode:</th>
		<td><input type="text" name="addresspostcode" value="<%= request.getAttribute("addresspostcode") == null ? "" : request.getAttribute("addresspostcode") %>"></td>
	</tr>
	<tr>
		<th>Address State:</th>
		<td>
			<select name="addressstate">
				<option value="ACT" selected="<%= request.getAttribute("addressstate") == "ACT" ? "true" : "false" %>">ACT</option>
				<option value="NSW" selected="<%= request.getAttribute("addressstate") == "NSW" ? "true" : "false" %>">NSW</option>
				<option value="NT"  selected="<%= request.getAttribute("addressstate") == "NT"  ? "true" : "false" %>">NT</option>	
				<option value="QLD" selected="<%= request.getAttribute("addressstate") == "QLD" ? "true" : "false" %>">QLD</option>						
				<option value="TAS" selected="<%= request.getAttribute("addressstate") == "TAS" ? "true" : "false" %>">TAS</option>
				<option value="VIC" selected="<%= request.getAttribute("addressstate") == "VIC" ? "true" : "false" %>">VIC</option>
				<option value="WA"  selected="<%= request.getAttribute("addressstate") == "WA"  ? "true" : "false" %>">WA</option>
			</select>
		</td>
	</tr>
</table>