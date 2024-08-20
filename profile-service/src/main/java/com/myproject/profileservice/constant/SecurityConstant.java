package com.myproject.profileservice.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author nguyenle
 */
@Component
public class SecurityConstant {

    @Value("${api.key}")
    private String INTERNAL_API_KEY;

    private String[] PUBLIC_ENDPOINTS = {

    };

    private String[] INTERNAL_ENDPOINTS = {
        "/internal/create"
    };

    public String getInternalApiKey() {
        return INTERNAL_API_KEY;
    }

    public String[] getPublicEndpoints() {
        return PUBLIC_ENDPOINTS;
    }

    public String[] getInternalEndpoints() {
        return INTERNAL_ENDPOINTS;
    }

}
