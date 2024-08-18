package com.myproject.userservice.service;

import com.myproject.userservice.payload.request.UserCreateRequest;
import com.myproject.userservice.payload.request.UserUpdateRequest;
import com.myproject.userservice.payload.response.UserResponse;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * @author nguyenle
 */
public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse getMyInfo();

    @PreAuthorize("hasRole('ADMIN')")
    UserResponse updateUser(String userId, UserUpdateRequest request);

    @PreAuthorize("hasRole('ADMIN')")
    void deleteUser(String userId);

    @PreAuthorize("hasRole('ADMIN')")
    List<UserResponse> getUsers();

    @PreAuthorize("hasRole('ADMIN')")
    UserResponse getUser(String userId);
}
