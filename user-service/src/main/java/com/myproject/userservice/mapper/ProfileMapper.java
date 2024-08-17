package com.myproject.userservice.mapper;

import com.myproject.userservice.payload.request.ProfileCreateRequest;
import com.myproject.userservice.payload.request.UserCreateRequest;
import org.mapstruct.Mapper;

/**
 * @author nguyenle
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreateRequest toProfileProfileCreateRequest(UserCreateRequest request);

}
