package com.myproject.userservice.exception;

import com.myproject.userservice.constant.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nguyenle
 */
@Getter
@Setter
public class AppException extends RuntimeException {

	private ErrorCode errorCode;

	public AppException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
