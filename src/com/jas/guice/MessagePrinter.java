package com.jas.guice;

import com.google.inject.Inject;

public class MessagePrinter {

	private MessageService messageService;

	@Inject
	public MessagePrinter(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void printMessage() {
		System.out.println(messageService.getMessage());
	}
}
