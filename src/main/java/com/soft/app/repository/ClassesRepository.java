package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.ClassRoutine;
import com.soft.app.model.classes;

@Repository("classRepository")

public interface ClassesRepository extends JpaRepository<classes, Long> {
	@Query("Select clas from ClassRoutine clas, classes cs,Batch b, Day d where d.id=clas.day.id and b.id=clas.batch1.id and cs.id=clas.class1.id and d.id=?1")
	List<ClassRoutine>getTodayClass(Long id);
}
