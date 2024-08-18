package com.myproject.userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.userservice.constant.ErrorCode;
import com.myproject.userservice.payload.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final ObjectMapper objectMapper;

	@Override
	public void commence(
		HttpServletRequest request,
		HttpServletResponse response,
		AuthenticationException authException
	) throws IOException, ServletException {
		ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;

		response.setStatus(errorCode.getStatusCode().value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		ApiResponse<?> apiResponse = ApiResponse.builder()
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.build();

		response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
		response.flushBuffer();

	}
}
