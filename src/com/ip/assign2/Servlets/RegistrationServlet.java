package com.ip.assign2.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		DbConnection db = new DbConnection();
		
		try {
			db.connect();
		} catch (Exception e) {
			throw new ServletException("Error connecting to the database", e);
		}
		
		boolean success = db.executeUpdate(DbCommand.INSERT_NEW_USER, params);
		
		try {
			db.close();
		} catch(SQLException e) {
			throw new ServletException("Error closing database connection", e);
		}
		
		if(!success) {
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
		
			request.getRequestDispatcher("/account/register.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/registration_success.jsp").forward(request, response);
		}
	}
}