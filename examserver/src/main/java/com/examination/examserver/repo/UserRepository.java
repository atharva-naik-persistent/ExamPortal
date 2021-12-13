package com.examination.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examination.examserver.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);

}