package com.myproject.userservice.mapper;

import com.myproject.userservice.model.User;
import com.myproject.userservice.payload.request.UserCreateRequest;
import com.myproject.userservice.payload.request.UserUpdateRequest;
import com.myproject.userservice.payload.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author nguyenle
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
