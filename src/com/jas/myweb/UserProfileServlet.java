package com.jas.myweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jas.myweb.domain.UserProfile;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet(name = "UserProfile", urlPatterns = { "/servlet/UserProfile" })
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		ServletContext context = request.getServletContext();
		Map<String, UserProfile> userProfileDb = (Map<String, UserProfile>) context.getAttribute("USER_DB");
		if (userProfileDb == null) {
			userProfileDb = new HashMap<String, UserProfile>();
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update((userName + password + email + "JASMINE").getBytes());
	        byte byteData[] = md.digest();
	        password = this.encryptedData(byteData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserProfile userProfile = new UserProfile();
		userProfile.setUserName(userName);
		userProfile.setPassword(password);
		userProfile.setFirstName(firstName);
		userProfile.setLastName(lastName);
		userProfile.setEmail(email);
		
		userProfileDb.put(userName, userProfile);
		
		context.setAttribute("USER_DB", userProfileDb);
		
		PrintWriter out = response.getWriter();
		out.print("Your user profile: " + firstName + " " + lastName + ", " + email);
	}
	
	private String encryptedData(byte[] data) {
		StringBuilder hexString = new StringBuilder();
    	for (int i=0;i<data.length;i++) {
    		String hex=Integer.toHexString(0xff & data[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}

}
