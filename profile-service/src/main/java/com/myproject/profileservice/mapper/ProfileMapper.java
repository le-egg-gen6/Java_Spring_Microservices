package com.myproject.profileservice.mapper;

import com.myproject.profileservice.model.Profile;
import com.myproject.profileservice.payload.request.ProfileCreateRequest;
import com.myproject.profileservice.payload.response.UserProfileResponse;
import org.mapstruct.Mapper;

/**
 * @author nguyenle
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toUserProfile(ProfileCreateRequest request);

    UserProfileResponse toUserProfileResponse(Profile entity);

}
