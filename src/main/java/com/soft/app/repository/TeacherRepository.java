package com.soft.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Teacher;

@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("Select tea from Teacher tea where tea not in(Select teacher from Teacher teacher, TeacherAttendence te where teacher.id=te.teacher.id and te.date=?1)")
	List<Teacher> getTeacherByDate(Date date1);
    
    

}
