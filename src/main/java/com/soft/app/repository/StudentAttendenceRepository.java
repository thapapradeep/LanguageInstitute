package com.soft.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Student;
import com.soft.app.model.StudentAttendence;

@Repository
public interface StudentAttendenceRepository extends JpaRepository<StudentAttendence, Long>{
     @Query("select st from Student st, classes c, StudentClass ss where st.id=ss.student.id and c.id=ss.classes.id and c.id=?1 and st not in(select ss from Student ss, classes cc, StudentAttendence sc where ss.id=sc.student.id and cc.id=sc.classes4.id and cc.id=?1 and sc.date= ?2)")
	List<Student>getStudentById(Long id, Date date);

     @Query("select sa from StudentAttendence sa, Student stu , classes clas where stu.id=sa.student.id and clas.id=sa.classes4.id and stu.id=?2 and clas.id=?1")
	List<StudentAttendence>getStudentAttendence(Long id, Long student_id);

}
