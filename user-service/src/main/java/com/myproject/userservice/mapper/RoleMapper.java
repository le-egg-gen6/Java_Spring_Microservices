package com.myproject.userservice.mapper;

import com.myproject.userservice.model.Role;
import com.myproject.userservice.payload.request.RoleRequest;
import com.myproject.userservice.payload.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author nguyenle
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

}
