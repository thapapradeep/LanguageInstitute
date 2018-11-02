package com.soft.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.soft.app.model.Student;
import com.soft.app.model.StudentClass;
import com.soft.app.model.classes;


@Repository
public interface StudentClassReopsitory extends JpaRepository<StudentClass, Long>{
	@Query("Select stu from Student stu, Batch b where b.id=stu.batch.id and b.id=?2 and stu NOT IN(Select s from Student s, classes c, Batch b, StudentClass st  where b.id=s.batch.id and s.id=st.student.id and c.id=st.classes.id and c.id=?1 and c.batch.id=s.batch.id)")
	List<Student> getClassStudent(Long class_id, Long batch_id);
	
	@Query("Select c from classes c, Student s, StudentClass sc where s.id=sc.student.id and c.id=sc.classes.id and s.id=?1 and c not in(Select clas.id from classes clas, Student s, StudentFee sf where clas.id=sf.classes.id and s.id=sf.student.id and s.id=?1)")
	List<classes>getClassByStudent(Long id);
	
	@Query("Select st  from Student st ,classes clas, StudentClass s where st.id=s.student.id and clas.id=s.classes.id and clas.id=?1 ")
	List<Student>getStudentByClasss(Long id);
	
	@Query("Select clas from classes clas where clas.id=?1")
	Optional<classes> getBatchByClass(Long id);

	@Query("Select st from Student st where st.id=?1")
	Optional<Student> getEmailById(Long id);

}
