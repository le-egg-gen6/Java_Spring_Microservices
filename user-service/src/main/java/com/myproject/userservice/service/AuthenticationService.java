package com.myproject.userservice.service;

import com.myproject.userservice.payload.request.AuthenticationRequest;
import com.myproject.userservice.payload.request.IntrospectRequest;
import com.myproject.userservice.payload.request.LogoutRequest;
import com.myproject.userservice.payload.request.RefreshRequest;
import com.myproject.userservice.payload.response.AuthenticationResponse;
import com.myproject.userservice.payload.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

/**
 * @author nguyenle
 */
public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;

    IntrospectResponse introspect(IntrospectRequest request);

    void logout(LogoutRequest request) throws ParseException, JOSEException;

}
