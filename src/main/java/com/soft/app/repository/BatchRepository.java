package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{

}
