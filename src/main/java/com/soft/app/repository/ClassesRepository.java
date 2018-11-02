package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.ClassRoutine;
import com.soft.app.model.Student;
import com.soft.app.model.classes;

@Repository("classRepository")

public interface ClassesRepository extends JpaRepository<classes, Long> {
	@Query("Select clas from ClassRoutine clas, classes cs,Batch b, Day d where d.id=clas.day.id and b.id=clas.batch1.id and cs.id=clas.class1.id and d.id=?1")
	List<ClassRoutine>getTodayClass(Long id);
	
	@Query("select c.className, count(s.id)as no_of_student from classes c, Student s, StudentClass sc where c.id=sc.classes.id and s.id=sc.student.id group by c.id")
	List<classes>getNumberOfStudents();
  
	@Query("select clas from classes clas, Batch b where b.id=clas.batch.id and b.id=?1")
	List<classes> getClassByBatch(Long id);
	
	
	@Query("Select st from Student st, Batch b where b.id=st.batch.id and b.id=?1")
	List<Student>getStudentByBatch(Long id);
}
