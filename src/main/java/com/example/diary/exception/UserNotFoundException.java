package com.example.diary.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
	}

	public UserNotFoundException(String error) {
		super(error);
	}
}
