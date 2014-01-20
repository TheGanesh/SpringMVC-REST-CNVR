package com.bestbuy.todo.si;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHandlingException;

public interface MessageHandler {
	
	public  Object handle(Message<Object> message) throws MessageHandlingException;

}
