package com.myproject.apigateway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.apigateway.constant.SecurityConstant;
import com.myproject.apigateway.payload.response.ApiResponse;
import java.util.Arrays;
import java.util.List;

import com.myproject.apigateway.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author nguyenle
 */
@Component
@RequiredArgsConstructor
@Order(value = -1)
@Slf4j
public class AuthenticationFilter implements GlobalFilter {

	private final ObjectMapper objectMapper;

	private final UserService userService;

	private final ApplicationConfig applicationConfig;

	private final SecurityConstant securityConstant;


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("Enter authentication filter....");

		if (isPublicEndpoint(exchange.getRequest())) {
			return chain.filter(exchange);
		}

		// Get token from authorization header
		List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
		if (CollectionUtils.isEmpty(authHeader)) {
			return unauthenticated(exchange.getResponse());
		}
		String token = authHeader.get(0).replace("Bearer ", "");
		log.info("Token: {}", token);

		return userService.introspect(token).flatMap(introspectResponse -> {
			if (introspectResponse.getResult().isValid()) {
				return chain.filter(exchange);
			} else {
				return unauthenticated(exchange.getResponse());
			}
		}).onErrorResume(throwable -> unauthenticated(exchange.getResponse()));
	}

	private boolean isPublicEndpoint(ServerHttpRequest request) {
		return Arrays.stream(securityConstant.getPublicEndpoints())
			.anyMatch(s -> request.getURI().getPath().matches(applicationConfig.getApiPrefix() + s));
	}

	private Mono<Void> unauthenticated(ServerHttpResponse response){
		ApiResponse<?> apiResponse = ApiResponse.builder()
			.code(1401)
			.message("Unauthenticated")
			.build();

		String body = null;
		try {
			body = objectMapper.writeValueAsString(apiResponse);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		return response.writeWith(Mono.just(response.bufferFactory().wrap(body.getBytes())));
	}

}
