package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Month;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long>{

}
