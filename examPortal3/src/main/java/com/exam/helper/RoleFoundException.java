package com.exam.helper;

public class RoleFoundException extends Exception {
	public RoleFoundException() {
		super("Role already exists. Try something else");
	}

	public RoleFoundException(String msg) {
		super(msg);
	}
}
