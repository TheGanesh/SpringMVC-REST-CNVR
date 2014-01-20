package com.bestbuy.todo.utils;

import java.text.MessageFormat;

public enum ErrorMessage {
	E001("The requested \"{1}\" is not found. (id={0})"), 
	E002("The count of un-finished \"Todo\" must be less than or equal to {0}."),
	E003("The requested \"Todo\" is already finished. (id={0})"),
	E101("{0} must not be null"),
	E102("{0}'s size must be between {1}");

	private final String format;

	private ErrorMessage(String format) {
		this.format = format;
	}

	public String getMessage(Object... args) {
		return MessageFormat.format(format, args);
	}
	
}
