package com.example.diary.domain.user;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@AllArgsConstructor
public class UserResponse {

	public enum Code {
		OK, EXIST, INVALID_REQUEST
	}

	private Code code;

	private UserResponse() {
	}
}
