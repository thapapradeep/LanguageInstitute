package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.TeacherAttendence;

@Repository("teacherAttendenceRepository")
public interface TeacherAttendenceRepository extends JpaRepository<TeacherAttendence, Long>{
	@Query("select att from TeacherAttendence att, Teacher sta where sta.id=att.teacher.id and sta.id=?1")
	List<TeacherAttendence>getteacherAttendenceHistory(Long id);
    
	@Query("Select count(tea) from TeacherAttendence tea where tea.teacher.id=?1 and tea.status='present' and month(tea.date)=?2")
	int getPresentDays(Long id, int month1);
     @Query("Select count(tea) from TeacherAttendence tea where tea.teacher.id=?1 and tea.status='absent' and month(tea.date)=?2")
	int getAbsentDays(Long id, int month1);
}
