package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Batch;
import com.soft.app.model.Student;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{
	
	@Query("select stu from Student stu, Batch b where b.id=stu.batch.id and b.id=?1")
	List<Student>getStudentByBatch(Long id);

}
