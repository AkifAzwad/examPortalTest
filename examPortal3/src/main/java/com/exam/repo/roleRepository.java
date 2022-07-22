package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Role;

public interface roleRepository extends JpaRepository<Role,Long> {

	Role findByroleName(String roleName);

}
