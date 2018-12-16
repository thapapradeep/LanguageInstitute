package com.soft.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Staff;
import com.soft.app.model.StaffSalaryHistory;
import com.soft.app.model.Teacher;
import com.soft.app.model.TeacherSalaryHistory;
import com.soft.app.model.Transaction;
import com.soft.app.repository.StaffSalaryRepository;
import com.soft.app.repository.TeacherSalaryRepository;
import com.soft.app.repository.TransactionRepository;

@Controller
public class SalaryHistoryController {
	@Autowired private StaffSalaryRepository staffRepository;
	@Autowired private TeacherSalaryRepository teacherRepository;
	@Autowired TransactionRepository transactionRepository;
	
	@ModelAttribute("staffSalary")
	public StaffSalaryHistory getStaffSalaryHistory() {
		return new StaffSalaryHistory();
	}
	
	@ModelAttribute("teacherSalary")
	public TeacherSalaryHistory getTeacherSalaryHistory() {
		return new TeacherSalaryHistory();
	}
	
	@RequestMapping(value="**/accountant/paySatff", method= {RequestMethod.POST, RequestMethod.GET})
	public String payToStaff(@RequestParam("id")Long id, @RequestParam("amount")double amount) {
		Staff staff=new Staff();
		staff.setId(id);
		StaffSalaryHistory sta=new StaffSalaryHistory();
		sta.setStaff(staff);
		sta.setAmount(amount);
		staffRepository.save(sta);
		
		Transaction ts=new Transaction();
		ts.setParticular("Staff Salary Paymant");
		ts.setStatus("expense");
		ts.setAmount(amount);
		transactionRepository.save(ts);
		 return "redirect:accountant/viewStaffs";
	}
	
	@RequestMapping(value="**/accountant/payTeacher", method= {RequestMethod.POST, RequestMethod.GET})
	public String payToTeacher(@RequestParam("id")Long id, @RequestParam("amount")double amount) {
		Teacher teacher=new Teacher();
		teacher.setId(id);
		TeacherSalaryHistory tea=new TeacherSalaryHistory();
		tea.setTeacher(teacher);
		tea.setAmount(amount);
		teacherRepository.save(tea);
		
		Transaction ts=new Transaction();
		ts.setParticular("Teacher Salary Paymant");
		ts.setStatus("expense");
		ts.setAmount(amount);
		transactionRepository.save(ts);
		 return "redirect:accountant/teachers";
	}
	
	@RequestMapping(value="**/manager/teacherHistory", method=RequestMethod.GET)
	public String loadViewteacherHistory(@RequestParam("id")Long id, Model model) {
		
		model.addAttribute("teacherList", teacherRepository.find(id));
		return "manager_teacherSalaryHistory";
		
	}
	
	@RequestMapping(value="**/manager/staffHistory", method=RequestMethod.GET)
	public String loadViewStaffHistory(@RequestParam("id")Long id, Model model) {
		
		model.addAttribute("staffList",  teacherRepository.findStaffSalary(id));
		return "manager_staffSalary";
		
	}
	

}
