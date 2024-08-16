package com.myproject.userservice.repository;

import com.myproject.userservice.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyenle
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

}
