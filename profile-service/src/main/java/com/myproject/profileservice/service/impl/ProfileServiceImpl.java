package com.myproject.profileservice.service.impl;

import com.myproject.profileservice.mapper.ProfileMapper;
import com.myproject.profileservice.model.Profile;
import com.myproject.profileservice.payload.request.ProfileCreateRequest;
import com.myproject.profileservice.payload.response.UserProfileResponse;
import com.myproject.profileservice.repository.ProfileRepository;
import com.myproject.profileservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final ProfileMapper profileMapper;


    @Override
    public UserProfileResponse createProfile(ProfileCreateRequest profileCreateRequest) {
        Profile userProfile = profileMapper.toUserProfile(profileCreateRequest);
        userProfile = profileRepository.save(userProfile);

        return profileMapper.toUserProfileResponse(userProfile);
    }

    @Override
    public UserProfileResponse getProfile(String id) {
        Profile userProfile =
                profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return profileMapper.toUserProfileResponse(userProfile);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> gatAllProfiles() {
        var profiles = profileRepository.findAll();

        return profiles.stream().map(profileMapper::toUserProfileResponse).toList();
    }
}
