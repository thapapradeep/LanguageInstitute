package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Student;
import com.soft.app.model.StudentAttendence;

@Repository
public interface StudentAttendenceRepository extends JpaRepository<StudentAttendence, Long>{
     @Query("Select s from Student s, classes c, StudentClass st  where s.id=st.student.id and c.id=st.classes.id and c.id=?1")
	List<Student>getStudentById(Long id);

     @Query("select sa from StudentAttendence sa, Student stu , classes clas where stu.id=sa.student.id and clas.id=sa.classes4.id and stu.id=?2 and clas.id=?1")
	List<StudentAttendence>getStudentAttendence(Long id, Long student_id);

}
