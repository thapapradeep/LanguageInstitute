package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.classes;

@Repository("classRepository")

public interface ClassesRepository extends JpaRepository<classes, Long> {

}
