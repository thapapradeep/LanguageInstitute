package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Role;

@Repository("roleRepository")
public interface RoleReopsitory extends JpaRepository<Role, Long> {
	

}
