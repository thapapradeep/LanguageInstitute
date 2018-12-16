package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Student;
import com.soft.app.model.StudentFee;
import com.soft.app.model.Transaction;
import com.soft.app.model.classes;
import com.soft.app.repository.StudentFeeRepository;
import com.soft.app.repository.TransactionRepository;

@Controller
public class StudentFeeController {
	@Autowired private StudentFeeRepository studentFeeRepository;
	@Autowired private TransactionRepository transactionRepository;
	
	
	@ModelAttribute("studentFee")
	public StudentFee getStudentFee() {
		return new StudentFee();
	}
	
	@RequestMapping(value="**/accountant/payFee", method= {RequestMethod.POST,RequestMethod.GET})
	public String PayFee(@RequestParam("id")Long id, @RequestParam("student_id")Long student_id, @RequestParam("amount")double amount) {
	Student st=new Student();
	classes clas=new classes();
	st.setId(student_id);
	clas.setId(id);
	StudentFee sf=new StudentFee();
	sf.setStudent(st);
	sf.setClasses(clas);
	sf.setStatus("paid");
	studentFeeRepository.save(sf);
	
	Transaction ts=new Transaction();
	ts.setParticular("Student Fee Paymant");
	ts.setStatus("income");
	ts.setAmount(amount);
	transactionRepository.save(ts);
		return "redirect:accountant/viewStudentClass?id="+student_id;	
	}

}
