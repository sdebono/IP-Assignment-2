package com.ip.assign2.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ip.assign2.Utils.DbConnection;

/**
 * Servlet implementation class RegistrationServlet
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
		
		try {
			db.close();
		} catch(SQLException e) {
			throw new ServletException("Error closing database connection", e);
		}
		
		if(!success) {
			//TODO: Need to show error message!
		
			request.getRequestDispatcher("/account/login.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}