package com.soft.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.ClassRoutine;

@Repository
public interface ClassRoutineReopsitory extends JpaRepository<ClassRoutine, Long>{
     @Query("select clas from ClassRoutine clas , Batch b where b.id=clas.batch1.id and b.id=?1")
	List<ClassRoutine>getRoutineByBatch(Long id);

     @Query("select clas from ClassRoutine clas , Batch b, Day d where b.id=clas.batch1.id and d.id=clas.day.id and d.id=?1 and b.id=?2")
 	List<ClassRoutine>getRoutineByDay(Long id, Long batch_id);
}
