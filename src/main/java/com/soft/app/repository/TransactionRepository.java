package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query("Select trans.balance from Transaction trans where trans.id=(select max(t.id) from Transaction t)")
	double getBalance();
	
	@Query("Select sum(t.amount) from Transaction t where t.particular='Student Fee Payment'and month(t.date)=?1")
	double getStudentFee(int month);
	
	@Query("Select sum(t.amount) from Transaction t where t.particular='Teacher Salary Payment'and month(t.date)=?1")
	double getTeacherSalary(int month);
	
	@Query("Select sum(t.amount) from Transaction t where t.particular='Staff Salary Payment' and month(t.date)=?1")
	double getStaffSalary(int month);
	
	@Query("select sum(t.amount) from Transaction t where t.status='expense' and t.particular not in('Teacher Salary Payment', 'Staff Salary Payment') and month(t.date)=?1")
	double getMiscExpense(int month);
	
	@Query("select sum(t.amount) from Transaction t where t.status='income' and t.particular not in('Student Fee Payment', 'Staff Salary Payment') and month(t.date)=?1")
	double getMiscIncome(int month);

	

}
