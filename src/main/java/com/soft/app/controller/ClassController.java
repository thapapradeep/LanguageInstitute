package com.soft.app.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.soft.app.model.Teacher;
import com.soft.app.model.classes;
import com.soft.app.repository.BatchRepository;
import com.soft.app.repository.ClassesRepository;
import com.soft.app.repository.LanguageRepository;
import com.soft.app.repository.TeacherLanguageRepository;


@Controller

public class ClassController {
	@Autowired private ClassesRepository classRepository;
	@Autowired private BatchRepository batchRepository;
	@Autowired private LanguageRepository languageRepository;
	@Autowired private TeacherLanguageRepository teacherLanguageRepo;
	
	@ModelAttribute("clas")
	private classes getClasses() {
		return new classes();
	}

	
	@RequestMapping(value="**/manager/addClasses", method=RequestMethod.GET)
	private String loadAddClassPage(Model model, Model model1) {
	   model1.addAttribute("languageList", languageRepository.findAll());
	   model.addAttribute("batchList", batchRepository.findAll());
		return "manager_addClass";
		
	}
	
	@RequestMapping(value="**/receptionist/addClasses", method=RequestMethod.GET)
	private String re_loadAddClassPage(Model model, Model model1) {
	   model1.addAttribute("languageList", languageRepository.findAll());
	   model.addAttribute("batchList", batchRepository.findAll());
		return "receptionist_addClasss";
		
	}
	
	@RequestMapping(value="**/manager/add-addClass", method=RequestMethod.POST)
	private String manager_addClass(@ModelAttribute("clas") classes clas) {
		classRepository.save(clas);
		return "redirect:manager/viewClasses";
		
	}
	@RequestMapping(value="**/receptionist/add-addClass", method=RequestMethod.POST)
	private String receptionistaddClass(@ModelAttribute("clas") classes clas) {
		classRepository.save(clas);
		return "redirect:receptionist/viewClasses";
		
	}
		
	@RequestMapping(value="**/manager/viewClasses", method=RequestMethod.GET)
	private String loadViewClasses(Model model) {
		model.addAttribute("ClassList", classRepository.findAll());
		return "manager_viewClass";
	}
	
	@RequestMapping(value="**/receptionist/viewClasses", method=RequestMethod.GET)
	private String re_loadViewClasses(Model model) {
		model.addAttribute("ClassList", classRepository.findAll());
		return "receptionist_viewClass";
	}
	

		
		@RequestMapping(value="**/accountant/viewClasses", method=RequestMethod.GET)
		private String loadaccountantViewUsers(Model model) {
			model.addAttribute("ClassList", classRepository.findAll());
			return "accountant_viewClass";
	}
	@RequestMapping(value="**/admin/viewClasses", method=RequestMethod.GET)
	private String loadreceptionistViewUsers(Model model) {
		model.addAttribute("ClassList", classRepository.findAll());
		return "admin_viewClass";
		
	}
	
	
	@RequestMapping(value="**/manager/updateClass", method=RequestMethod.GET)
	private String loadUpdateClassForm( @RequestParam("id")Long id, Model model, Model model1, Model model2) {
      Optional<classes> clas=classRepository.findById(id);
      classes c=clas.get();
      model.addAttribute("clas", c);
      model1.addAttribute("languageList", languageRepository.findAll());
      model2.addAttribute("batchList", batchRepository.findAll());
      
	return "manager_updateClass";
		
		
	}
	@RequestMapping(value="**/receptionist/updateClass", method=RequestMethod.GET)
	private String rec_loadUpdateClassForm( @RequestParam("id")Long id, Model model, Model model1, Model model2) {
      Optional<classes> clas=classRepository.findById(id);
      classes c=clas.get();
      model.addAttribute("clas", c);
      model1.addAttribute("languageList", languageRepository.findAll());
      model2.addAttribute("batchList", batchRepository.findAll());
      
	return "receptionist_updateClass";
		
		
	}
	
	@RequestMapping(value="**/manager/update-updateClass", method=RequestMethod.POST)
	private String updateClass(@ModelAttribute("clas")classes clas) {
		
		classRepository.save(clas);
		return"redirect:manager/viewClasses";
	}
	
	
	@RequestMapping(value="**/receptionist/update-updateClass", method=RequestMethod.POST)
	private String rec_updateClass(@ModelAttribute("clas")classes clas) {
		
		classRepository.save(clas);
		return"redirect:receptionist/viewClasses";
	}
	@RequestMapping(value="**/manager/deleteClass", method=RequestMethod.GET)
	private String deleteClass(@RequestParam("id")Long id) {
		classRepository.deleteById(id);
		return "redirect:manager/viewClasses";
	}
	
	@RequestMapping(value="/GetTeacherByLanguage/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Teacher> getTeacherByLanguage(@PathVariable("id")long id){
		try {
			System.out.println("I am called");
		List<Teacher> teachers=teacherLanguageRepo.loadTeacherByLanguage(id);
		System.out.println(teachers);
		for(Teacher t:teachers) {
			System.out.println(t.getAddress());
			System.out.println(t.getLastname());
		}
		return teachers;
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	

}
