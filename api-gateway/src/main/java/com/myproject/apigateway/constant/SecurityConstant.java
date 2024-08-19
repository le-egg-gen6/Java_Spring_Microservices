package com.myproject.apigateway.constant;

import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
public class SecurityConstant {

	private String[] PUBLIC_ENDPOINTS = {
		"/user/auth/.*",
		"/user/user/registration",
	};

	public String[] getPublicEndpoints() {
		return PUBLIC_ENDPOINTS;
	}

}
