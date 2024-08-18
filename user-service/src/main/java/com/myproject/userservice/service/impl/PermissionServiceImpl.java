package com.myproject.userservice.service.impl;

import com.myproject.userservice.mapper.PermissionMapper;
import com.myproject.userservice.model.Permission;
import com.myproject.userservice.payload.request.PermissionRequest;
import com.myproject.userservice.payload.response.PermissionResponse;
import com.myproject.userservice.repository.PermissionRepository;
import com.myproject.userservice.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl implements PermissionService {


    private final PermissionRepository permissionRepository;

    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }

}
