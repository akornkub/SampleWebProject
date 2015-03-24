<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map, com.jas.myweb.domain.UserProfile" %>
    
<%
	String userName = null;
	String password = null;
	String firstName = null;
	String lastName = null;
	String email = null;
	
	Map<String, UserProfile> userProfileDb = (Map<String, UserProfile>) application.getAttribute("USER_DB");
	if (userProfileDb != null) {
		UserProfile userProfile = userProfileDb.get( request.getParameter("userName") );
		if (userProfile != null) {
			userName = userProfile.getUserName();
			password = userProfile.getPassword();
			firstName = userProfile.getFirstName();
			lastName = userProfile.getLastName();
			email = userProfile.getEmail();
		}
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
User name: <%= userName %><br>
Password: <%= password %><br>
Name: <%= firstName %> <%= lastName %><br>
Email: <%= email %><br>
</body>
</html>