package com.myproject.userservice.service;

import com.myproject.userservice.payload.request.RoleRequest;
import com.myproject.userservice.payload.response.RoleResponse;

import java.util.List;

/**
 * @author nguyenle
 */
public interface RoleService {
    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAll();

    void delete(String role);
}
