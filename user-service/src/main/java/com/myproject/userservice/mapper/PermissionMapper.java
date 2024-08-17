package com.myproject.userservice.mapper;

import com.myproject.userservice.model.Permission;
import com.myproject.userservice.payload.request.PermissionRequest;
import com.myproject.userservice.payload.response.PermissionResponse;
import org.mapstruct.Mapper;

/**
 * @author nguyenle
 */
@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionResponse toPermissionResponse(Permission permission);

    Permission toPermission(PermissionRequest request);

}
