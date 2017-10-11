package com.example.diary.web.general.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {

	private boolean success;

	private ApiError error;

	private T response;

	public ApiResponse(T response) {
		this.response = response;
		this.success = true;
	}

	public ApiResponse(String message, HttpStatus status) {
		success = false;
		response = null;
		this.error = new ApiError(message, status);
	}

	public ApiResponse(Throwable throwable, HttpStatus status) {
		success = false;
		response = null;
		this.error = new ApiError(throwable, status);
	}

}
