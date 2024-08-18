package com.myproject.userservice.repository;

import com.myproject.userservice.model.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyenle
 */
@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
}
