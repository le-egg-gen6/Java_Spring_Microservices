package com.myproject.userservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * @author nguyenle
 */
@Getter
public enum ErrorCode {

	INVALID_KEY(1001, "Uncategorized Error", HttpStatus.BAD_REQUEST),
	UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
	UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
	;

	ErrorCode(int code, String message, HttpStatusCode statusCode) {
		this.code = code;
		this.message = message;
		this.statusCode = statusCode;
	}

	private final int code;

	private final String message;

	private final HttpStatusCode statusCode;
}
