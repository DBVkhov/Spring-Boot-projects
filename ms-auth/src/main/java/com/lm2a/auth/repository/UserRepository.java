package com.lm2a.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lm2a.auth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findUserByUsername(String username);
}
