package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.RoleRequest;
import com.myproject.userservice.payload.response.ApiResponse;
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

    }

    @GetMapping
    public ApiResponse<?> getAll() {

    }

    @PostMapping("/update")
    public ApiResponse<?> update(
            @RequestParam String role,
            @RequestBody RoleRequest request
    ) {

    }

    @DeleteMapping("/delete")
    public ApiResponse<?> delete(@RequestParam String role) {

    }

}
