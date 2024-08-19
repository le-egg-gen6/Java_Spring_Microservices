package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.RoleRequest;
import com.myproject.userservice.payload.ApiResponse;
import com.myproject.userservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author nguyenle
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/create")
    public ApiResponse<?> create(@RequestBody RoleRequest request) {
        return ApiResponse.builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return ApiResponse.builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/delete")
    public ApiResponse<?> delete(@RequestParam String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }

}
