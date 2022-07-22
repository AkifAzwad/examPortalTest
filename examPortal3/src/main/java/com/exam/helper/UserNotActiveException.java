package com.exam.helper;

public class UserNotActiveException extends Exception {
	public UserNotActiveException() {
		super("User with this username not active yet, ask admin for permission");
	}

	public UserNotActiveException(String msg) {
		super(msg);
	}
}
