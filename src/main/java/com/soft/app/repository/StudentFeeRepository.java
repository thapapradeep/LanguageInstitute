package com.soft.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.app.model.StudentFee;

@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFee, Long>{

}
