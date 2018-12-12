package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.ClassRoutine;

@Repository
public interface ClassRoutineReopsitory extends JpaRepository<ClassRoutine, Long>{

}
