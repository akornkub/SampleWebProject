package com.jas.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jas.myweb.domain.UserProfile;

@Path("/UserProfile")
public class UserProfileService {

	@POST
	@Consumes("application/json")
	public Response create(UserProfile userProfile) {
		String result = "";
		if (userProfile != null) {
			System.out.println("userName=" + userProfile.getUserName());
			System.out.println("password=" + userProfile.getPassword());
			System.out.println("name=" + userProfile.getFirstName()
					+ " " + userProfile.getLastName());
			System.out.println("email=" + userProfile.getEmail());
			
			result = "User profile created for " + userProfile.getUserName();
		}
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/{userName}")
	@Produces("application/json")
	public Response get(@PathParam("userName") String userName) {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserName(userName);
		userProfile.setFirstName("RESTful");
		userProfile.setLastName("Service");
		userProfile.setEmail("rest@jasmine.com");
		
		return Response.status(200).entity(userProfile).build();
	}
}
