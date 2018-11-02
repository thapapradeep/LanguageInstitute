package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.StaffAttendence;

@Repository
public interface StaffAttendenceReopsitory extends JpaRepository<StaffAttendence, Long>{
	@Query("select att from StaffAttendence att, Staff sta where sta.id=att.staff.id and sta.id=?1")
	List<StaffAttendence>getStaffAttendenceHistory(Long id);

	@Query("Select count(sta) from StaffAttendence sta where sta.staff.id=?1 and sta.status='present' and month(sta.date)=?2")
	int getPresentDays(Long id, int month);
	
	@Query("Select count(sta) from StaffAttendence sta where sta.staff.id=?1 and sta.status='absent' and month(sta.date)=?2")
	int getAbsentDays(Long id, int month);
}
