package com.exam.helper;

public class UserNotFoundException extends Exception {
    
    public UserNotFoundException() {
	super("User with this username does not exist.");
    }
    
    public UserNotFoundException(String msg) {
   	super(msg);
       }
    
}
