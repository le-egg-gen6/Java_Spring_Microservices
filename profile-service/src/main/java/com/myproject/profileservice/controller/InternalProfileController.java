package com.myproject.profileservice.controller;

import com.myproject.profileservice.payload.ApiResponse;
import com.myproject.profileservice.payload.request.ProfileCreateRequest;
import com.myproject.profileservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nguyenle
 */
@RestController
@RequiredArgsConstructor
public class InternalProfileController {

    private final ProfileService profileService;

    @PostMapping("/internal/create")
    public ApiResponse<?> createProfile(@RequestBody ProfileCreateRequest request) {
        return ApiResponse.builder()
                .result(profileService.createProfile(request))
                .build();
    }

}
