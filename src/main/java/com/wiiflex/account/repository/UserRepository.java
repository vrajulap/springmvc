package com.wiiflex.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiiflex.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
