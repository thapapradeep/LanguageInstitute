package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.TeacherAttendence;

@Repository("teacherAttendenceRepository")
public interface TeacherAttendenceRepository extends JpaRepository<TeacherAttendence, Long>{

}
