package com.exam.helper;

public class EntityNotFoundException extends Exception {
	public EntityNotFoundException(String ob) {
		super(ob + " not found");
	}
	public EntityNotFoundException() {
		super("Entity not found");
	}
}
