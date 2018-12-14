package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Student;
import com.soft.app.model.StudentAttendence;
import com.soft.app.model.classes;
import com.soft.app.repository.StudentAttendenceRepository;
import com.soft.app.repository.StudentClassReopsitory;

@Controller
public class StudentAttendenceController {
	@Autowired private StudentAttendenceRepository studentAttendenceRepository;
	@Autowired private StudentClassReopsitory studentClassrepository;
	
	@ModelAttribute("studentAttendence")
	public StudentAttendence getStudentAttendence() {
		return new StudentAttendence();
	}

   @RequestMapping(value="**/receptionist/attendStudent")
   public String loadStudentAttendencePage(@RequestParam("class_id")Long id, Model model, Model model1)
   {
	   classes clas=new classes();
	   clas.setId(id);
	   model1.addAttribute("clas", clas);
	 model.addAttribute("studentList", studentAttendenceRepository.getStudentById(id));
	 return "receptionist_studentAttendence";
   }
   
   @RequestMapping(value="**/receptionist/present-student", method={RequestMethod.POST, RequestMethod.GET})
   public String presentStudent(@RequestParam("id")Long id, @RequestParam("class_id")Long class_id ) {
	   classes clas=new classes();
		Student st=new Student();
		clas.setId(class_id);
		st.setId(id);
		StudentAttendence studentAttendence=new StudentAttendence();
		studentAttendence.setClasses4(clas);
		studentAttendence.setStudent(st);
		studentAttendence.setStatus("present");
		studentAttendenceRepository.save(studentAttendence);
		return "redirect:receptionist/attendStudent?class_id="+class_id;
		
   }
   @RequestMapping(value="**/receptionist/absent-student", method= {RequestMethod.POST, RequestMethod.GET})
   public String absentStudent(@RequestParam("id")Long id, @RequestParam("class_id")Long class_id ) {
	   classes clas=new classes();
		Student st=new Student();
		clas.setId(class_id);
		st.setId(id);
		StudentAttendence studentAttendence=new StudentAttendence();
		studentAttendence.setClasses4(clas);
		studentAttendence.setStudent(st);
		studentAttendence.setStatus("present");
		studentAttendenceRepository.save(studentAttendence);
		return "redirect:receptionist/attendStudent?class_id="+class_id;
		
   }
	
   @RequestMapping(value="**/manager/viewStudentClass", method= {RequestMethod.GET, RequestMethod.GET})
   public String viewStudentClass(@RequestParam("id")Long id, Model model, Model model1) {
	   model.addAttribute("classList", studentClassrepository.getClassByStudent(id));
	   Student st=new Student();
	   st.setId(id);
	   model1.addAttribute("student", st);
	   return "manager_viewStudentClass";
   }
   
   
   @RequestMapping(value="**/manager/viewStudentAttendence", method= {RequestMethod.GET, RequestMethod.GET})
   public String viewStudentAttendenceClass(@RequestParam("id")Long id, @RequestParam("student_id")Long student_id, Model model) {
	model.addAttribute("studentAttendenceList", studentAttendenceRepository.getStudentAttendence(id, student_id));
	return "manager_viewStudentAttendence";
   }

}