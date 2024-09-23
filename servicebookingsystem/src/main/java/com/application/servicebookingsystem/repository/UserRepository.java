package com.application.servicebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.servicebookingsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findFirstByEmail(String email);
}
