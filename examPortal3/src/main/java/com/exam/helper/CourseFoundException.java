package com.exam.helper;

public class CourseFoundException extends Exception {
	public CourseFoundException() {
		super("Course already exists. Try something else");
	}

	public CourseFoundException(String msg) {
		super(msg);
	}
}
