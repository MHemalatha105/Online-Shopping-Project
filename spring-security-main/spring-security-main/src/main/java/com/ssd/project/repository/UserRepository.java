package com.ssd.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsernameOrEmail(String username, String Email);

	Boolean existsByUsername(String userName);

	Optional<User> findByUsername(String Username);

	Boolean existsByEmail(String email);

}
