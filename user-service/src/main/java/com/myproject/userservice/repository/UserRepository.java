package com.myproject.userservice.repository;

import com.myproject.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyenle
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}