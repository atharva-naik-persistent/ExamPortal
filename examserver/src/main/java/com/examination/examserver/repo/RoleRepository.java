package com.examination.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examination.examserver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}