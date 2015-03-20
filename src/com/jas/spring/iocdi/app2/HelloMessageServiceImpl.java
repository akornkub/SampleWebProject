package com.jas.spring.iocdi.app2;

public class HelloMessageServiceImpl implements MessageService {

	public String getMessage() {
		return "Hello, using beans.xml";
	}
}
