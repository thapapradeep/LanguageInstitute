package com.soft.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="**/accountant/viewunPaid", method=RequestMethod.GET)
	public String loadUnPaidStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("studentList", studentFeeRepository.getUnpaidStudents(id));
		return "accountant_viewUnpaidStudents";
	
	}
	@RequestMapping(value="**/accountant/viewPaid", method=RequestMethod.GET)
	public String loadPaidStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("studentList", studentFeeRepository.getPaidStudents(id));
		return "accountant_viewPaidStudents";
	
	}
	
	
	@RequestMapping(value="**/accountant/payFee", method= {RequestMethod.POST,RequestMethod.GET})
	public String PayFee(@RequestParam("id")Long id, @RequestParam("student_id")Long student_id, @RequestParam("amount")double amount)throws Exception {
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date date =new Date(); 
	    Date date1=dateFormat.parse(dateFormat.format(date));
		Student st=new Student();
	classes clas=new classes();
	st.setId(student_id);
	clas.setId(id);
	StudentFee sf=new StudentFee();
	sf.setStudent(st);
	sf.setClasses(clas);
	sf.setDate(date1);
	sf.setAmount(amount);
	sf.setStatus("paid");
	studentFeeRepository.save(sf);
	
	Transaction ts=new Transaction();
	
   ts.setDate(date1);
	ts.setParticular("Student Fee Payment");
	ts.setStatus("income");
	 double balance=transactionRepository.getBalance();
     double newbalance=balance+amount;
      ts.setBalance(newbalance);
	ts.setAmount(amount);
	transactionRepository.save(ts);
		return "redirect:accountant/viewStudentClass?id="+student_id;	
	}

}
