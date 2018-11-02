package com.soft.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Staff;

@Repository("staffRepository")

public interface StaffRepository extends JpaRepository<Staff, Long> {
	@Query("Select sta from Staff sta where sta not in(Select staff from Staff staff, StaffAttendence se where staff.id=se.staff.id and se.date=?1)")
    List<Staff>getStaffByDate(Date date);
	
	@Query("Select sta from Staff sta where sta.id=?1")
	List<Staff>getStaffById(Long id);
}
