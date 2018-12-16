package com.soft.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Staff;
import com.soft.app.model.StaffSalaryHistory;

@Repository
public interface StaffSalaryRepository extends JpaRepository<StaffSalaryHistory, Long>{
 
	@Query("select sta from Staff sta where sta not in (select s from Staff s,StaffSalaryHistory st where s.id=st.staff.id and MONTH(st.date)=?1)")
	List<Staff>getUnPaidStaff(int month);
	
	@Query("Select sta from Staff sta where sta in(select s from Staff s, StaffSalaryHistory st where s.id=st.staff.id and MONTH(st.date)=?1)")
	List<Staff>getPaidStaff(int month);

}
