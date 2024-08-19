package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.PermissionRequest;
import com.myproject.userservice.payload.ApiResponse;
import com.myproject.userservice.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author nguyenle
 */
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
@Slf4j
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/create")
    public ApiResponse<?> create(@RequestBody PermissionRequest request) {
        return ApiResponse.builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return ApiResponse.builder()
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("/delete")
    public ApiResponse<?> delete(@RequestParam String permission) {
        permissionService.delete(permission);
        return ApiResponse.<Void>builder().build();
    }

}
