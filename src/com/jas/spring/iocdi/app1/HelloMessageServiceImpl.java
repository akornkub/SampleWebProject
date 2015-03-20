package com.jas.spring.iocdi.app1;

public class HelloMessageServiceImpl implements MessageService {

	public String getMessage() {
		return "Hello, using Autowired";
	}
}
