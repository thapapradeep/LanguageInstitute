package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Day;

@Repository
public interface DayRepository extends JpaRepository<Day,Long>{

}
