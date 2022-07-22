package com.exam.helper;

public class InvalidEventException extends Exception {
	public InvalidEventException() {
		super("Invalid time, end time should be after start time");
	}

	public InvalidEventException(String msg) {
		super(msg);
	}
}
