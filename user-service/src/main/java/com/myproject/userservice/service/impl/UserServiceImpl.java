package com.myproject.userservice.service.impl;

import com.myproject.userservice.constant.ErrorCode;
import com.myproject.userservice.constant.PredefinedRole;
import com.myproject.userservice.exception.AppException;
import com.myproject.userservice.httpclient.ProfileServiceClient;
import com.myproject.userservice.kafka.event.NotificationEvent;
import com.myproject.userservice.mapper.ProfileMapper;
import com.myproject.userservice.mapper.UserMapper;
import com.myproject.userservice.model.Role;
import com.myproject.userservice.model.User;
import com.myproject.userservice.payload.request.ProfileCreateRequest;
import com.myproject.userservice.payload.request.UserCreateRequest;
import com.myproject.userservice.payload.request.UserUpdateRequest;
import com.myproject.userservice.payload.response.UserResponse;
import com.myproject.userservice.repository.RoleRepository;
import com.myproject.userservice.repository.UserRepository;
import com.myproject.userservice.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	private final UserMapper userMapper;

	private final ProfileMapper profileMapper;

	private final ProfileServiceClient profileServiceClient;

	private final PasswordEncoder passwordEncoder;

	private final KafkaTemplate<String, Object> kafkaTemplate;

	private final int CORE_POOL_SIZE = 5;

	private final int MAX_POOL_SIZE = 10;

	private final int THREAD_LIFE_CYCLE_IN_MINUTE = 1;

	private ExecutorService executorService;

	@PostConstruct
	private void init() {
		initThreadPool();
	}

	private void initThreadPool() {
		executorService = new ThreadPoolExecutor(
				CORE_POOL_SIZE,
				MAX_POOL_SIZE,
				THREAD_LIFE_CYCLE_IN_MINUTE,
				TimeUnit.MINUTES,
				new LinkedBlockingQueue<>()
		);
	}

	private void addAsyncOperation(Runnable task) {
		executorService.submit(task);
	}

	@Override
	public UserResponse createUser(UserCreateRequest request) {
		User user = userMapper.toUser(request);

		user.setPassword(passwordEncoder.encode(request.getPassword()));
		Set<Role> roles = new HashSet<>();

		roleRepository.findById(PredefinedRole.USER_ROLE).ifPresent(roles::add);

		user.setRoles(roles);
		user.setEmailVerified(false);

		try {
			user = userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new AppException(ErrorCode.USER_EXISTED);
		}

		ProfileCreateRequest profileCreateRequest = profileMapper.toProfileProfileCreateRequest(request);
		profileCreateRequest.setUserId(user.getId());

		var response = profileServiceClient.createProfile(profileCreateRequest);

		addAsyncOperation(() -> {
			NotificationEvent notificationEvent = NotificationEvent.builder()
					.channel("EMAIL")
					.recipient(request.getEmail())
					.subject("Welcome to NguyenLe Shop")
					.body("Hello, " + request.getUsername())
					.build();
			kafkaTemplate.send("notification-delivery", notificationEvent);
		});

		var userCreationResponse = userMapper.toUserResponse(user);
		userCreationResponse.setId(response.getResult().getId());
		return userCreationResponse;
	}

	@Override
	public UserResponse getMyInfo() {
		var context = SecurityContextHolder.getContext();
		String name = context.getAuthentication().getName();

		User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

		return userMapper.toUserResponse(user);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public UserResponse updateUser(String userId, UserUpdateRequest request) {
		User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

		userMapper.updateUser(user, request);
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		var roles = roleRepository.findAllById(request.getRoles());
		user.setRoles(new HashSet<>(roles));

		return userMapper.toUserResponse(userRepository.save(user));
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public List<UserResponse> getUsers() {
		return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public UserResponse getUser(String userId) {
		return userMapper.toUserResponse(
				userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED))
		);
	}
}
