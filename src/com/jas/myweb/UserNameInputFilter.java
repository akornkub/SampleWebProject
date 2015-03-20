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
 * Servlet Filter implementation class UserNameInputFilter
 */
@WebFilter("/servlet/UserProfile")
public class UserNameInputFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserNameInputFilter() {
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

		String userName = request.getParameter("userName");
		if (userName.length() < 5) {
			request.setAttribute("errorMessage", "Username's length is less than 5.");
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
