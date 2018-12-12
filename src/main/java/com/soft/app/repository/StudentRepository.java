package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Student;
@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

}
