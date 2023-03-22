package com.furkancitilci.repository;

import com.furkancitilci.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile,Long> {

    Optional<UserProfile> findOptionalByAuthId(Long id);
    Optional<UserProfile> findOptionalByUsernameEqualsIgnoreCase(String username);
}
