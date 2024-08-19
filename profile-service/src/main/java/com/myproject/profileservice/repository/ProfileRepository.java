package com.myproject.profileservice.repository;

import com.myproject.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author nguyenle
 */
@Service
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
