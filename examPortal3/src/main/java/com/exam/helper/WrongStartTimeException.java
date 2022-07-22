package com.exam.helper;

public class WrongStartTimeException extends Exception {
	public WrongStartTimeException() {
		super("Start time is wrong");
	}
}
