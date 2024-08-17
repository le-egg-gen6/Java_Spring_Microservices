package com.myproject.userservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author nguyenle
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {

    private String name;

    private String description;

    private Set<PermissionResponse> permissions;
}
