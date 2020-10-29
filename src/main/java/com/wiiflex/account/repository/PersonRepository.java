package com.wiiflex.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiiflex.account.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
