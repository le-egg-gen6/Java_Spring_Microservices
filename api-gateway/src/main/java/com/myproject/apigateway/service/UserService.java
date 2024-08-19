package com.myproject.apigateway.service;

import com.myproject.apigateway.payload.response.ApiResponse;
import com.myproject.apigateway.payload.response.IntrospectResponse;
import reactor.core.publisher.Mono;

/**
 * @author nguyenle
 */
public interface UserService {

    Mono<ApiResponse<IntrospectResponse>> introspect(String token);

}
