package com.soft.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Student;
import com.soft.app.model.StudentFee;

@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFee, Long>{
   @Query("Select stu from Student stu, classes cl , StudentClass sl where stu.id=sl.student.id and cl.id=sl.classes.id and cl.id=?1 and stu not in(select s from Student s, classes c, StudentFee sf where s.id=sf.student.id and c.id=sf.classes.id and c.id=?1)")
   List<Student>getUnpaidStudents(Long id);


  @Query("Select stu from Student stu, classes cl , StudentClass sl where stu.id=sl.student.id and cl.id=sl.classes.id and cl.id=?1 and stu  in(select s from Student s, classes c, StudentFee sf where s.id=sf.student.id and c.id=sf.classes.id and c.id=?1)")
   List<Student>getPaidStudents(Long id);
}
