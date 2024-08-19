package com.myproject.apigateway.constant;

import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
public class SecurityConstant {

	private String[] PUBLIC_ENDPOINTS = {
		"/identity/auth/.*",
		"/identity/users/registration",
	};

	public String[] getPublicEndpoints() {
		return PUBLIC_ENDPOINTS;
	}

}
