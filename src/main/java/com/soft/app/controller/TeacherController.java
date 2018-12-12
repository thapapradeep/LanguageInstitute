package com.soft.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Teacher;
import com.soft.app.repository.LanguageRepository;
import com.soft.app.repository.TeacherRepository;

@Controller
public class TeacherController {
	@Autowired private TeacherRepository teacherRepository;
	@Autowired private LanguageRepository languageRepository;
	
	@ModelAttribute("teacher")
	public Teacher getTeacher() {
		return new Teacher();
	}
	
	@RequestMapping(value="**/receptionist/addTeacher",method=RequestMethod.GET)
	public String loadAddTeacherForm(Model model) {
		model.addAttribute("languageList", languageRepository.findAll());
		return "receptionist_addTeachers";
	}
	
	@RequestMapping(value="**/receptionist/add-addTeacher", method=RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher")Teacher teacher) {
			
 	  teacher.setStatus("Enabled");
		
		teacherRepository.save(teacher);
       return "redirect:receptionist/teachers";
		
	}
	
	@RequestMapping(value="**/manager/teachers", method=RequestMethod.GET)
	public String loadAllTeachers(Model model) {
		model.addAttribute("teacherList", teacherRepository.findAll());
		return "manager_viewTeachers";
	}
	@RequestMapping(value="**/receptionist/teachers", method=RequestMethod.GET)
	public String re_loadAllTeachers(Model model) {
		model.addAttribute("teacherList", teacherRepository.findAll());
		return "receptionist_viewTeachers";
	}
		
		@RequestMapping(value="**/accountant/teachers", method=RequestMethod.GET)
		public String ac_loadAllTeachers(Model model) {
			model.addAttribute("teacherList", teacherRepository.findAll());
			return "accountant_viewTeachers";
	
	}
		
		@RequestMapping(value="**/admin/teachers", method=RequestMethod.GET)
		public String ad_loadAllTeachers(Model model) {
			model.addAttribute("teacherList", teacherRepository.findAll());
			return "admin_viewTeachers";
	
	}
	
	@RequestMapping(value="**/manager/updateTeachers", method=RequestMethod.GET)
	public String UpdateTecher(@RequestParam("id") long id, Model model) {
		Optional<Teacher> teacher=teacherRepository.findById(id);
		Teacher t=teacher.get();
		model.addAttribute("teacher", t);
		return "manager_updateTeacher";
	}
	
	@RequestMapping(value="**/receptionist/updateTeachers", method=RequestMethod.GET)
	public String re_UpdateTecher(@RequestParam("id") long id, Model model) {
		Optional<Teacher> teacher=teacherRepository.findById(id);
		Teacher t=teacher.get();
		model.addAttribute("teacher", t);
		return "receptionist_updateTeacher";
	}
	@RequestMapping(value="**/manager/update-updateTeacher", method=RequestMethod.POST)
	public String UpdateTeachers(@ModelAttribute("teacher") Teacher teacher) {
		
		teacherRepository.save(teacher);
		return"redirect:manager/teachers";
		
	}
	
	@RequestMapping(value="**/receptionist/update-updateTeacher", method=RequestMethod.POST)
	public String re_UpdateTeachers(@ModelAttribute("teacher") Teacher teacher) {
		
		teacherRepository.save(teacher);
		return"redirect:receptionist/teachers";
		
	}
	
	@RequestMapping(value="**/manager/deleteTeachers" , method=RequestMethod.GET)
	public String deleteTeacher(@RequestParam("id") long id) {
		teacherRepository.deleteById(id);
		return "redirect:manager/teachers";
		
	}
	
	

}
