package com.jas.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class HelloApplication3 {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new HelloModule());
		
		MessageService messageService = injector.getInstance(MessageService.class);
		
		MessagePrinter messagePrinter = new MessagePrinter(messageService);
		messagePrinter.printMessage();
	}
}
