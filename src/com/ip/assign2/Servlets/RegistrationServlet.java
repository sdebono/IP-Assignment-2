package com.ip.assign2.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ip.assign2.Beans.UserBean;
import com.ip.assign2.Utils.DbCommand;
import com.ip.assign2.Utils.DbConnection;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vector<String> params = new Vector<String>();
		
		params.add(request.getParameter("username"));
		params.add(request.getParameter("password"));
		params.add(request.getParameter("firstname"));
		params.add(request.getParameter("lastname"));
		params.add(request.getParameter("email"));
		params.add(request.getParameter("phone"));
		params.add(request.getParameter("creditcardnumber"));
		params.add(request.getParameter("addressnumber"));
		params.add(request.getParameter("addressstreet"));
		params.add(request.getParameter("addresssuburb"));
		params.add(request.getParameter("addressstate"));
		params.add(request.getParameter("addresspostcode"));
		
		for(String p : params) {
			//TODO: Add proper field validation here!
			if(p == null || p.length() == 0) {
				//User has not filled out field!
				request.setAttribute("username", params.get(0));
				request.setAttribute("password", params.get(1));
				request.setAttribute("firstname", params.get(2));
				request.setAttribute("lastname", params.get(3));
				request.setAttribute("email", params.get(4));
				request.setAttribute("phone", params.get(5));
				request.setAttribute("creditcardnumber", params.get(6));
				request.setAttribute("addressnumber", params.get(7));
				request.setAttribute("addressstreet", params.get(8));
				request.setAttribute("addresssuburb", params.get(9));
				request.setAttribute("addressstate", params.get(10));
				request.setAttribute("addresspostcode", params.get(11));
				
				request.setAttribute("is_error", true);
				request.setAttribute("error_message", "Please fill out all fields");
				request.getRequestDispatcher("/account/register.jsp").forward(request, response);
				return;
			}
		}
		
		DbConnection db = new DbConnection();
		
		try {
			db.connect();
		} catch (Exception e) {
			throw new ServletException("Error connecting to the database", e);
		}
		
		boolean success = db.executeUpdate(DbCommand.INSERT_NEW_USER, params);
		
		if(!success) {
			//Close the DB connection
			try {
				db.close();
			} catch(SQLException e) {
				throw new ServletException("Error closing database connection", e);
			}
			
			//Pass the variables entered in the form back to the user for revision
			request.setAttribute("username", params.get(0));
			request.setAttribute("password", params.get(1));
			request.setAttribute("firstname", params.get(2));
			request.setAttribute("lastname", params.get(3));
			request.setAttribute("email", params.get(4));
			request.setAttribute("phone", params.get(5));
			request.setAttribute("creditcardnumber", params.get(6));
			request.setAttribute("addressnumber", params.get(7));
			request.setAttribute("addressstreet", params.get(8));
			request.setAttribute("addresssuburb", params.get(9));
			request.setAttribute("addressstate", params.get(10));
			request.setAttribute("addresspostcode", params.get(11));
		
			request.setAttribute("is_error", true);
			request.setAttribute("error_message", "Username already taken. Please choose another");
			
			request.getRequestDispatcher("/account/register.jsp").forward(request, response);
		} else {
			//Log user in
			String username = params.get(0);
			String password = params.get(1);
			
			//Get the user's details
			Vector<String> args = new Vector<String>();
			args.add(username);
			Map<String, String> userDetails = db.executeSingleReader(DbCommand.GET_USER_DETAILS, args);
			
			if(userDetails == null) {
				response.sendError(-1, "Couldn't find details for user: " + username);
			}
			
			//Create the session bean
			UserBean user = new UserBean();
			
			user.setUsername(username);
			user.setPassword(password);
			user.setFirstName(userDetails.get("FIRST_NAME"));
			user.setLastName(userDetails.get("LAST_NAME"));
			user.setEmail(userDetails.get("EMAIL"));
			user.setPhone(userDetails.get("PHONE"));
			user.setCreditCardNumber(userDetails.get("CREDIT_CARD_NUMBER"));
			user.setAddressId(userDetails.get("ADDRESS_ID"));
			user.setAddressNumber(userDetails.get("ADDRESS_NUMBER"));
			user.setAddressStreet(userDetails.get("ADDRESS_STREET"));
			user.setAddressSuburb(userDetails.get("ADDRESS_SUBURB"));
			user.setAddressState(userDetails.get("ADDRESS_STATE"));
			user.setAddressPostcode(userDetails.get("ADDRESS_POSTCODE"));
			
			user.isLoggedIn(true);
			
			request.getSession().setAttribute("user", user);
			
			//Close the DB connection
			try {
				db.close();
			} catch(SQLException e) {
				throw new ServletException("Error closing database connection", e);
			}
			
			request.getRequestDispatcher("/account/registration_success.jsp").forward(request, response);
		}
	}
}