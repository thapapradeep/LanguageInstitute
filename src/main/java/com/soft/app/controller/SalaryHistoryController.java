package com.soft.app.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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
import com.soft.app.repository.StaffAttendenceReopsitory;
import com.soft.app.repository.StaffRepository;
import com.soft.app.repository.StaffSalaryRepository;
import com.soft.app.repository.TeacherAttendenceRepository;
import com.soft.app.repository.TeacherRepository;
import com.soft.app.repository.TeacherSalaryRepository;
import com.soft.app.repository.TransactionRepository;

@Controller
public class SalaryHistoryController {
	@Autowired private StaffSalaryRepository staffRepository;
	@Autowired private StaffRepository staff;
	@Autowired private TeacherRepository teacher;
	@Autowired private StaffAttendenceReopsitory staffAttendence;
	@Autowired private TeacherAttendenceRepository teacherAttendence;
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
	
	@RequestMapping(value="**/accountant/payStaff", method= {RequestMethod.POST, RequestMethod.GET})
	public String payToStaff(@RequestParam("id")Long id, @RequestParam("amount")double amount)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
		Staff staff=new Staff();
		staff.setId(id);
		StaffSalaryHistory sta=new StaffSalaryHistory();
		sta.setStaff(staff);
		sta.setDate(date1);
		sta.setAmount(amount);
		staffRepository.save(sta);
		
		Transaction ts=new Transaction();
		ts.setParticular("Staff Salary Payment");
		
       ts.setDate(date1);
       double balance=transactionRepository.getBalance();
       double newbalance=balance-amount;
       ts.setBalance(newbalance);
		ts.setStatus("expense");
		ts.setAmount(amount);
		transactionRepository.save(ts);
		 return "redirect:accountant/viewStaffSlip&id="+id;
	}
	
	@RequestMapping(value="**/accountant/payTeacher", method= {RequestMethod.POST, RequestMethod.GET})
	public String payToTeacher(@RequestParam("id")Long id, @RequestParam("amount")double amount)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date =new Date(); 
	    Date date1=dateFormat.parse(dateFormat.format(date));
	    
		Teacher teacher=new Teacher();
		teacher.setId(id);
		TeacherSalaryHistory tea=new TeacherSalaryHistory();
		tea.setTeacher(teacher);
		tea.setDate(date1);
		tea.setAmount(amount);
		teacherRepository.save(tea);
		
		Transaction ts=new Transaction();
		
       
		ts.setParticular("Teacher Salary Payment");
		  double balance=transactionRepository.getBalance();
	       double newbalance=balance-amount;
	       ts.setBalance(newbalance);
		ts.setStatus("expense");
		ts.setAmount(amount);
		transactionRepository.save(ts);
		 return "redirect:accountant/viewTeacherSlip?id="+id;
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
	
	
	@RequestMapping(value="**/accountant/viewStaffSlip", method=RequestMethod.GET)
	public String viewStaffSalarySlip(@RequestParam("id")Long id, Model model1,Model model2,Model model3,Model model4, Model model5)throws Exception{
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
		int month1=month+1;
		Date date=calendar.getTime();
		model5.addAttribute("date", date);
		Optional<Staff>st=staff.findById(id);
		Staff stt=st.get();
		model1.addAttribute("staff", stt);
		int present=staffAttendence.getPresentDays(id, month1);
		int absent=staffAttendence.getAbsentDays(id, month1);
		double salary=stt.getRole().getSalary();
		double netSalary=(30-absent)*(salary/30);
		model2.addAttribute("present", present);
		model3.addAttribute("absent", absent);
		model4.addAttribute("netSalary", netSalary);
		return "accountant_staffSalarySlip";
	}
	
	@RequestMapping(value="**/accountant/viewTeacherSlip", method=RequestMethod.GET)
	public String viewTeacherSalarySlip(@RequestParam("id")Long id, Model model1,Model model2,Model model3,Model model4, Model model5)throws Exception{
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
		int month1=month+1;
		Date date=calendar.getTime();
		model5.addAttribute("date", date);
		Optional<Teacher>st=teacher.findById(id);
		Teacher te=st.get();
		model1.addAttribute("teacher", te);
		int present=teacherAttendence.getPresentDays(id, month1);
		int absent=teacherAttendence.getAbsentDays(id, month1);
		double salary=te.getSalary();
		double netSalary=(30-absent)*(salary/30);
		model2.addAttribute("present", present);
		model3.addAttribute("absent", absent);
		model4.addAttribute("netSalary", netSalary);
		return "accountant_teacherSalarySlip";
	}
	
}
