package com.myproject.profileservice.controller;

import com.myproject.profileservice.payload.ApiResponse;
import com.myproject.profileservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nguyenle
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/user")
    public ApiResponse<?> getProfile(@RequestParam String profileId) {
        return ApiResponse.builder()
                .result(profileService.getProfile(profileId))
                .build();
    }

    @GetMapping("/users")
    public ApiResponse<?> getAllProfiles() {
        return ApiResponse.builder()
                .result(profileService.gatAllProfiles())
                .build();
    }

}
