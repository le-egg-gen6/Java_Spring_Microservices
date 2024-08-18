package com.myproject.userservice.service;

import com.myproject.userservice.payload.request.PermissionRequest;
import com.myproject.userservice.payload.response.PermissionResponse;

import java.util.List;

/**
 * @author nguyenle
 */
public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getAll();

    void delete(String permission);
}
