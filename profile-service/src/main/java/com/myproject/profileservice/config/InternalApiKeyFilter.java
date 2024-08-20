package com.myproject.profileservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.profileservice.constant.ErrorCode;
import com.myproject.profileservice.constant.SecurityConstant;
import com.myproject.profileservice.payload.ApiResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author nguyenle
 */
@Component
@RequiredArgsConstructor
public class InternalApiKeyFilter extends OncePerRequestFilter {

    private final SecurityConstant securityConstant;

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        if (isInternalRequest(requestUri)) {
            String apiKey = request.getHeader("Internal");
            if (isApiKeyValid(apiKey)) {
                filterChain.doFilter(request, response);
            } else {
                ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

                response.setStatus(errorCode.getStatusCode().value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                ApiResponse<?> apiResponse = ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build();

                response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
                response.flushBuffer();
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean isInternalRequest(String uri) {
        return Arrays.stream(securityConstant.getInternalEndpoints())
                .anyMatch(uri::startsWith);
    }

    private boolean isApiKeyValid(String apiKey) {
        return apiKey.equals(securityConstant.getInternalApiKey());
    }
}
