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


@Controller
public class StudentClassController {
	@Autowired private StudentClassReopsitory studentClassRepository;

	
	
	
	@ModelAttribute("studentClass")
	public StudentClass getStudentClass() {
		return new StudentClass();
	}
	
	@RequestMapping(value="**/receptionist/addStudentClass", method=RequestMethod.GET)
	public String loadAddStudentClassPage(@RequestParam("class_id")Long id,@RequestParam("batch_id")Long batch_id, Model model, Model model1) {
		classes clas=new classes();
		clas.setId(id);
		model1.addAttribute("clas", clas);
		model.addAttribute("studentList", studentClassRepository.getClassStudent(id, batch_id));
		return "receptionist_addClassStudent";
		
	}
	
	@RequestMapping(value="**/receptionist/add-addStudentClass", method= {RequestMethod.GET, RequestMethod.POST})
	public String addStudentClass(@RequestParam("id")Long id, @RequestParam("class_id")Long class_id) {
		classes clas=new classes();
		Student st=new Student();
		clas.setId(class_id);
		st.setId(id);
		StudentClass studentClass=new StudentClass();
		studentClass.setStudent(st);
		studentClass.setClasses(clas);
		studentClassRepository.save(studentClass);
		Long batch_id=studentClassRepository.getBatchByClass(class_id).get().getBatch().getId();
		return "redirect:receptionist/addStudentClass?class_id="+class_id+"&batch_id="+batch_id;
	}
	
	@RequestMapping(value="**/accountant/viewStudentClass", method= RequestMethod.GET)
	public String acc_viewStudentClass(@RequestParam("id")Long id, Model model, Model model1) {
		Student s=new Student();
		s.setId(id);
		model1.addAttribute("student",s);
		model.addAttribute("classList", studentClassRepository.getClassByStudent(id));
		return "accountant_viewStudentFee";
	}
	
	
	

}
