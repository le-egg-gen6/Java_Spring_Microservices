package com.myproject.apigateway.httpclient;

import com.myproject.apigateway.payload.request.IntrospectRequest;
import com.myproject.apigateway.payload.response.ApiResponse;
import com.myproject.apigateway.payload.response.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * @author nguyenle
 */
public interface UserServiceClient {

    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);

}
