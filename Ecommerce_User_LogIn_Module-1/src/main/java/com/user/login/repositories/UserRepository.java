package com.user.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);

}
