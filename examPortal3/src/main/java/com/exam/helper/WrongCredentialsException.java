package com.exam.helper;

public class WrongCredentialsException extends Exception {
	public WrongCredentialsException() {
		super("Incorrect Credentials");
	}

	public WrongCredentialsException(String msg) {
		super(msg);
	}
}
