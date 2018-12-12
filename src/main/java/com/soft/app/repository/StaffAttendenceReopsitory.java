package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.StaffAttendence;

@Repository("staffAttendenceRepository")
public interface StaffAttendenceReopsitory extends JpaRepository<StaffAttendence, Long>{

}
