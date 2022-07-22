package com.exam.helper;

public class CourseNotFoundException extends Exception {
	public CourseNotFoundException() {
		super("Course does not exist. Try something else");
	}

	public CourseNotFoundException(String msg) {
		super(msg);
	}
}
