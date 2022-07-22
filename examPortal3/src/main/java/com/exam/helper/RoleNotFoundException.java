package com.exam.helper;

public class RoleNotFoundException extends Exception {
	public RoleNotFoundException() {
		super("Role does not exist. Try something else");
	}

	public RoleNotFoundException(String msg) {
		super(msg);
	}
}
