package com.jas.spring.iocdi.app1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class HelloApplication1 {

	public static void main(String[] args) {
		ApplicationContext context = 
		          new AnnotationConfigApplicationContext(HelloApplicationConfig.class);
		      MessagePrinter printer = context.getBean(MessagePrinter.class);
		      printer.printMessage();
	}
}
