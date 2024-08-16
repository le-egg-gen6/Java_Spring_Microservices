package com.myproject.userservice.repository;

import com.myproject.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyenle
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
