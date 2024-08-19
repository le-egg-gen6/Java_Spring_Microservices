package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.AuthenticationRequest;
import com.myproject.userservice.payload.request.IntrospectRequest;
import com.myproject.userservice.payload.request.LogoutRequest;
import com.myproject.userservice.payload.request.RefreshRequest;
import com.myproject.userservice.payload.ApiResponse;
import com.myproject.userservice.payload.response.AuthenticationResponse;
import com.myproject.userservice.payload.response.IntrospectResponse;
import com.myproject.userservice.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author nguyenle
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<?> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse result = authenticationService.authenticate(request);
        return ApiResponse.builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<?> authenticate(
            @RequestBody IntrospectRequest request
    ) {
        IntrospectResponse result = authenticationService.introspect(request);
        return ApiResponse.builder()
                .result(result)
                .build();
    }

    @PostMapping("/refresh")
    public ApiResponse<?> authenticate(
            @RequestBody RefreshRequest request
    ) throws ParseException, JOSEException {
        AuthenticationResponse result = authenticationService.refreshToken(request);
        return ApiResponse.builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    public ApiResponse<?> logout(
            @RequestBody LogoutRequest request
    ) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.builder()
                .build();
    }
}
