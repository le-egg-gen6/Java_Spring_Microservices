package com.myproject.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nguyenle
 */
@Entity
@Table(name = "t_permission")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Permission {

	@Id
	private String name;

	String description;

}
