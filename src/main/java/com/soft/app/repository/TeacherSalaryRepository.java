package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.StaffSalaryHistory;
import com.soft.app.model.Teacher;
import com.soft.app.model.TeacherSalaryHistory;

@Repository
public interface TeacherSalaryRepository extends JpaRepository<TeacherSalaryHistory, Long>{
	@Query("Select th from TeacherSalaryHistory th , Teacher t where t.id=th.teacher.id and t.id=?1")
	List<TeacherSalaryHistory> find(Long id);
	
	@Query("Select sh from StaffSalaryHistory sh , Staff s where s.id=sh.staff.id and s.id=?1") 
	List<StaffSalaryHistory> findStaffSalary(Long id);
	
	
	@Query("Select tea from Teacher tea where tea not in(select t from Teacher t, TeacherSalaryHistory ts where t.id=ts.teacher.id and MONTH(ts.date)=?1)")
	List<Teacher>getUnPaidTeacher(int month);
	
	@Query("Select tea from Teacher tea where tea  in(select t from Teacher t, TeacherSalaryHistory ts where t.id=ts.teacher.id and MONTH(ts.date)=?1)")
	List<Teacher>getPaidTeacher(int month);
	
	

}
