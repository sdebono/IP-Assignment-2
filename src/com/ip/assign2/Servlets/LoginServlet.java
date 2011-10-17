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
 * Servlet to validate login and set session parameters
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String username= request.getParameter("username");
		String password = request.getParameter("password");

		DbConnection db = new DbConnection();
		
		try {
			db.connect();
		} catch (Exception e) {
			throw new ServletException("Error connecting to the database", e);
		}
		
		boolean success = db.validateLogin(username, password);
		
		if(!success) {
			//Close the DB connection
			try {
				db.close();
			} catch(SQLException e) {
				throw new ServletException("Error closing database connection", e);
			}
			
			request.setAttribute("is_error", true);
			request.setAttribute("error_message", "Incorrect username/password. Please try again");
			request.getRequestDispatcher("/account/login.jsp").forward(request, response);
		} else {
			
			//Get the user's details
			Vector<String> params = new Vector<String>();
			params.add(username);
			Map<String, String> userDetails = db.executeSingleReader(DbCommand.GET_USER_DETAILS, params);
			
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
			
			//Go to the homepage
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}