package com.myproject.userservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
public class SecurityConstant {

	@Value("${jwt.access.secret-key}")
	private String JWT_SECRET_KEY;

	@Value("${jwt.access.expiry-hour}")
	private Long JWT_EXPIRE_TIME;

	@Value("jwt.refresh.expiry-hour")
	private Long JWT_REFRESHABLE_TIME;

	private String[] PUBLIC_ENDPOINT = {
		"/users/registration",
		"/auth/token",
		"/auth/introspect",
		"/auth/logout",
		"/auth/refresh"
	};

	public String getSecretKey() {
		return JWT_SECRET_KEY;
	}

	public Long getExpireTimeInHour() {
		return JWT_EXPIRE_TIME;
	}

	public Long getRefreshableTimeInhour() {
		return JWT_REFRESHABLE_TIME;
	}

	public String[] getPublicEndpoints() {
		return PUBLIC_ENDPOINT;
	}

}
