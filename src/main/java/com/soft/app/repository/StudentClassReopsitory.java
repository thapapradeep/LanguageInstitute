package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.soft.app.model.Student;
import com.soft.app.model.StudentClass;
import com.soft.app.model.classes;


@Repository
public interface StudentClassReopsitory extends JpaRepository<StudentClass, Long>{
	@Query("Select stu from Student stu where stu NOT IN(Select s from Student s, classes c, StudentClass st  where s.id=st.student.id and c.id=st.classes.id and c.id=?1)")
	List<Student> getClassStudent(Long class_id);
	
	@Query("Select clas from classes clas , Student s,StudentClass st where s.id=st.student.id and clas.id=st.classes.id and s.id=?1")
	List<classes>getClassByStudent(Long id);
	
	

}
