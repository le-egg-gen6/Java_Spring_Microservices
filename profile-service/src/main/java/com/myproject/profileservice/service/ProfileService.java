package com.myproject.profileservice.service;

import com.myproject.profileservice.payload.request.ProfileCreateRequest;
import com.myproject.profileservice.payload.response.UserProfileResponse;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * @author nguyenle
 */
public interface ProfileService {

    UserProfileResponse createProfile(ProfileCreateRequest profileCreateRequest);

    UserProfileResponse getProfile(String id);

    @PreAuthorize("hasRole('ADMIN')")
    List<UserProfileResponse> gatAllProfiles();

}
