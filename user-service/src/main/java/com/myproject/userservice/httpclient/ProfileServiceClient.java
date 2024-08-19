package com.myproject.userservice.httpclient;

import com.myproject.userservice.config.AuthenticationRequestInterceptor;
import com.myproject.userservice.payload.request.ProfileCreateRequest;
import com.myproject.userservice.payload.response.ApiResponse;
import com.myproject.userservice.payload.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author nguyenle
 */
@FeignClient(
        name = "profile-service",
        url = "${app.services.profile}",
        configuration = { AuthenticationRequestInterceptor.class }
)
public interface ProfileServiceClient {

    @PostMapping(value = "/internal/user", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreateRequest request);

}
