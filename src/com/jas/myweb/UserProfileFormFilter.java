package com.jas.myweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UserProfileFormFilter
 */
@WebFilter("/servlet/UserProfile")
public class UserProfileFormFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserProfileFormFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		String errorMessage = "";
		
		if (request.getParameter("userName").equals(""))
			errorMessage = "Username is invalid.";
		
		if (request.getParameter("password").equals(""))
			errorMessage += "\nPassword is invalid.";
		
		if (request.getParameter("firstName").equals(""))
			errorMessage += "\nFirstname is invalid.";
		
		if (request.getParameter("lastName").equals(""))
			errorMessage += "\nLastname is invalid.";

		if (request.getParameter("email").equals(""))
			errorMessage += "\nEmail is invalid.";
		
		if (!errorMessage.equals("")) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/userprofile/view/UserProfileError.jsp").forward(request, response);
		} else {
	
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
