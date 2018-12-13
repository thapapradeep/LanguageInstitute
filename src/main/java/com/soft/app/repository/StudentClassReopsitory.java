package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Batch;
import com.soft.app.model.Student;
import com.soft.app.model.StudentClass;

@Repository
public interface StudentClassReopsitory extends JpaRepository<StudentClass, Long>{
	//@Query("Select stu from Student stu, classes clas, StudentClass st, Batch b where stu.id=st.student_id and clas.id=id and b.id=stu.batch_id and b.id=?1")
	//List<Student> getClassStudent(Batch batch_id);

}
