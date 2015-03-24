package com.jas.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jas.jpa.ProductRestEasyService;
import com.jas.jpa.controller.UserProfileJPAService;

@ApplicationPath("/resteasy/*")
public class UserProfileApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public UserProfileApplication() {
		singletons.add(new UserProfileService());
		singletons.add(new ProductRestEasyService());
		singletons.add(new UserProfileJPAService());

	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
