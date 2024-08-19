package com.myproject.userservice.controller;

import com.myproject.userservice.payload.request.UserCreateRequest;
import com.myproject.userservice.payload.request.UserUpdateRequest;
import com.myproject.userservice.payload.ApiResponse;
import com.myproject.userservice.payload.response.UserResponse;
import com.myproject.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nguyenle
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@PostMapping("/registration")
	public ApiResponse<?> registration(@RequestBody @Valid UserCreateRequest request) {
		return ApiResponse.builder()
				.result(userService.createUser(request))
				.build();
	}

	@GetMapping
	public ApiResponse<List<UserResponse>> getUsers() {
		return ApiResponse.<List<UserResponse>>builder()
				.result(userService.getUsers())
				.build();
	}

	@GetMapping("/{userId}")
	public ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
		return ApiResponse.<UserResponse>builder()
				.result(userService.getUser(userId))
				.build();
	}

	@GetMapping("/my-info")
	public ApiResponse<UserResponse> getMyInfo() {
		return ApiResponse.<UserResponse>builder()
				.result(userService.getMyInfo())
				.build();
	}

	@DeleteMapping("/delete")
	public ApiResponse<String> deleteUser(@RequestParam String userId) {
		userService.deleteUser(userId);
		return ApiResponse.<String>builder().result("User has been deleted").build();
	}

	@PutMapping("/update")
	public ApiResponse<UserResponse> updateUser(
			@RequestParam String userId,
			@RequestBody UserUpdateRequest request
	) {
		return ApiResponse.<UserResponse>builder()
				.result(userService.updateUser(userId, request))
				.build();
	}
}
