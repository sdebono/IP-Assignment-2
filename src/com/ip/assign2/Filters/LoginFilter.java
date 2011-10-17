package com.ip.assign2.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ip.assign2.Beans.UserBean;
import com.ip.assign2.Utils.Log;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public LoginFilter() {

    }

    public void init(FilterConfig fConfig) throws ServletException {
    	
	}
    
    public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		UserBean user = (UserBean)((HttpServletRequest)request).getSession().getAttribute("user");
		
		if(user == null || !user.isLoggedIn()) {
			Log.info("Redirecting to login page");
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/account/login.jsp");
		} else {
			Log.info("User logged in. Continuing");
			chain.doFilter(request, response);
		}
	}
}
