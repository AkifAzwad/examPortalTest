package com.exam.helper;

public class EntityFoundException extends Exception {
	public EntityFoundException(String ob) {
		super(ob+" found");
	}
	public EntityFoundException() {
		super("Entity found");
	}
}
