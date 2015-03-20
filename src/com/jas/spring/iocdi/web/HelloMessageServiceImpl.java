package com.jas.spring.iocdi.web;

public class HelloMessageServiceImpl implements MessageService {

	public String getMessage() {
		return "Hello, using root-context.xml and Spring MVC";
	}
}
