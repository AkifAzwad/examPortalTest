package com.exam.helper;

public class WrongEndTimeException extends Exception {
	public WrongEndTimeException() {
		super("End time is wrong");
	}
}
