package com.myproject.apigateway.service.impl;

import com.myproject.apigateway.httpclient.UserServiceClient;
import com.myproject.apigateway.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserServiceClient userServiceClient;

}
