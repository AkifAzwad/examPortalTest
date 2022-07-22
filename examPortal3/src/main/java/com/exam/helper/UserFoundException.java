package com.exam.helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this username already exists. Try something else");
	}

	public UserFoundException(String msg) {
		super(msg);
	}

}
