package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.PermissionRequest;
import com.myproject.userservice.payload.response.ApiResponse;
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

    @PostMapping("/create")
    public ApiResponse<?> create(@RequestBody PermissionRequest request) {

    }

    @GetMapping
    public ApiResponse<?> getAll() {

    }

    @PostMapping("/update")
    public ApiResponse<?> update(
            @RequestParam String permission,
            @RequestBody PermissionRequest request
    ) {

    }

    @DeleteMapping("/delete")
    public ApiResponse<?> delete(@RequestParam String permission) {

    }

}
