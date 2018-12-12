package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Staff;

@Repository("staffRepository")

public interface StaffRepository extends JpaRepository<Staff, Long> {

}
