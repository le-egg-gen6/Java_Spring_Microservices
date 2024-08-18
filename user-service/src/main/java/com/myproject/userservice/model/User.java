package com.myproject.userservice.model;

import jakarta.persistence.*;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nguyenle
 */
@Entity
@Table(name = "t_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "email", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
	private String email;

	@Column(name = "email_verified", nullable = false, columnDefinition = "boolean default false")
	private boolean emailVerified;

	@Column(name = "username", unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
	private String username;

	private String password;

	@ManyToMany
	Set<Role> roles;

}
