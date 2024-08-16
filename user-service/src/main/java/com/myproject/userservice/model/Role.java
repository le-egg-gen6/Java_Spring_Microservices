package com.myproject.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nguyenle
 */
@Entity
@Table(name = "t_role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role {

	@Id
	private String name;

	private String description;

	@ManyToMany
	Set<Permission> permissions;
}
