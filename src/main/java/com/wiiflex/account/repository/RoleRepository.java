package com.wiiflex.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiiflex.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
