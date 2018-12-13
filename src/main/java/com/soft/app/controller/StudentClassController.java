package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Student;
import com.soft.app.model.StudentClass;
import com.soft.app.model.classes;
import com.soft.app.repository.StudentClassReopsitory;
import com.soft.app.repository.StudentRepository;

@Controller
public class StudentClassController {
	@Autowired private StudentClassReopsitory studentClassRepository;
	@Autowired private StudentRepository studentRepository;
	
	
	
	@ModelAttribute("studentClass")
	public StudentClass getStudentClass() {
		return new StudentClass();
	}
	
	@RequestMapping(value="**/receptionist/addStudentClass", method=RequestMethod.GET)
	public String loadAddStudentClassPage(@RequestParam("class_id") Long id, Model model, Model model1) {
		classes clas=new classes();
		clas.setId(id);
		model1.addAttribute("clas", clas);
		model.addAttribute("studentList", studentRepository.findAll());
		return "receptionist_addClassStudent";
		
	}
	
	@RequestMapping(value="**/receptionist/add-addStudentClass", method= {RequestMethod.GET, RequestMethod.POST})
	public String addStudentClass(@RequestParam("id") Long id, @RequestParam("class_id")Long class_id) {
		classes clas=new classes();
		Student st=new Student();
		clas.setId(class_id);
		st.setId(id);
		StudentClass studentClass=new StudentClass();
		studentClass.setStudent(st);
		studentClass.setClasses(clas);
		studentClassRepository.save(studentClass);
		return "redirect:receptionist/addStudentClass?class_id="+class_id;
	}
	

}
