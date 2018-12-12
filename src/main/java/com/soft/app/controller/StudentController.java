package com.soft.app.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Student;
import com.soft.app.repository.StudentRepository;

@Controller

public class StudentController {
	@Autowired private StudentRepository studentRepository;
	
	@ModelAttribute("student")
	public Student getStudent() {
		return new Student();
	}
	
	@RequestMapping(value="**/receptionist/addStudent")
	public String loadAddStudentForm() {
		return"receptionist_addStudent";
	}
	
	@RequestMapping(value="**/receptionist/add-addStudent", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		student.setAddedDate(new Date());
		student.setStatus("Enabled");
		studentRepository.save(student);
		return "redirect:receptionist/students";
		
	}
	
	@RequestMapping(value="**/receptionist/students", method=RequestMethod.GET)
	public String receptionist_viewAllStudents(Model model) {
		
		model.addAttribute("studentlist" ,studentRepository.findAll());
		return "receptionist_viewStudent";
	}
	@RequestMapping(value="**/manager/students", method=RequestMethod.GET)
	public String viewAllStudents(Model model) {
		
		model.addAttribute("studentlist" ,studentRepository.findAll());
		return "manager/viewStudent";
	}
	
	
	@RequestMapping(value="**/accountant/students", method=RequestMethod.GET)
	public String ac_viewAllStudents(Model model) {
		
		model.addAttribute("studentlist" ,studentRepository.findAll());
		return "accountant_viewStudent";
	}
	
	@RequestMapping(value="**/admin/students", method=RequestMethod.GET)
	public String ad_viewAllStudents(Model model) {
		
		model.addAttribute("studentlist" ,studentRepository.findAll());
		return "admin_viewStudent";
	}
	
	
	@RequestMapping(value="**/manager/updateStudents", method=RequestMethod.GET)
	public String loadUpdateStudent(@RequestParam("id") Long id, Model model) {
		Optional<Student> student=studentRepository.findById(id);
		Student s=student.get();
		model.addAttribute("student", s);
		return "manager_updateStudent";
		
	}
	
	@RequestMapping(value="**/receptionist/updateStudents", method=RequestMethod.GET)
	public String rec_loadUpdateStudent(@RequestParam("id") Long id, Model model) {
		Optional<Student> student=studentRepository.findById(id);
		Student s=student.get();
		model.addAttribute("student", s);
		return "receptionist_updateStudent";
		
	}
	
	@RequestMapping(value="**/manager/update-updateStudent", method=RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student")Student student) {
		student.setAddedDate(new Date());
		studentRepository.save(student);
		return"redirect:manager/students";
	}
	
	@RequestMapping(value="**/receptionist/update-updateStudent", method=RequestMethod.POST)
	public String rec_updateStudent(@ModelAttribute("student")Student student) {
		student.setAddedDate(new Date());
		studentRepository.save(student);
		return"redirect:receptionist/students";
	}
	
	
	@RequestMapping(value="**/manager/deleteStudents", method=RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") Long id) {
		studentRepository.deleteById(id);
		return "redirect:manager/students";
	}
}
