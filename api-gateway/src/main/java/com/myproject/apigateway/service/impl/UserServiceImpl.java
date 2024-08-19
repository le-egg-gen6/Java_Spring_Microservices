package com.myproject.apigateway.service.impl;

import com.myproject.apigateway.httpclient.UserServiceClient;
import com.myproject.apigateway.payload.request.IntrospectRequest;
import com.myproject.apigateway.payload.response.ApiResponse;
import com.myproject.apigateway.payload.response.IntrospectResponse;
import com.myproject.apigateway.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserServiceClient userServiceClient;

    @Override
    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return userServiceClient.introspect(IntrospectRequest.builder()
                .token(token)
                .build()
        );
    }
}
