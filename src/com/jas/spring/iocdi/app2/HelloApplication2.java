package com.jas.spring.iocdi.app2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jas.spring.iocdi.app2.MessagePrinter;

public class HelloApplication2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/jas/spring/iocdi/app2/beans.xml");
		
		MessageService messageService = (MessageService) ctx.getBean("messageService");
        
        MessagePrinter messagePrinter = new MessagePrinter(messageService);
		messagePrinter.printMessage();
	}
}
