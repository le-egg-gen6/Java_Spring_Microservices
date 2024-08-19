package com.myproject.profileservice.constant;

import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
public class SecurityConstant {

    private String[] PUBLIC_ENDPOINTS = {
        "/internal/create"
    };

    public String[] getPublicEndpoints() {
        return PUBLIC_ENDPOINTS;
    }

}
