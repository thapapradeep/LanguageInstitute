package com.soft.app.controller;

///import java.util.HashMap;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Language;
import com.soft.app.model.Teacher;
import com.soft.app.model.TeacherLanguage;
import com.soft.app.repository.TeacherLanguageRepository;
import com.soft.app.repository.TeacherRepository;

@Controller
public class TeaacherLanguageController {
	@Autowired  private TeacherLanguageRepository teacherLanguageRepository;
	@Autowired private TeacherRepository teacherRepository;
	
	
	@ModelAttribute("teacherlanguage")
	public TeacherLanguage getTeacherLanguage() {
		return new TeacherLanguage();
	}
	
	@RequestMapping(value="**/manager/teacherlanguages", method=RequestMethod.GET)
	public String loadTeacherlanguageForm(@RequestParam("id")long id,Model model) {
		Optional<Teacher> teacher=teacherRepository.findById(id);
		Teacher t=teacher.get();
		model.addAttribute("teacher", t);
		model.addAttribute("languageList", teacherLanguageRepository.loadLanguageByTeacher(id));
		return "manager_addLanguageTeacher";
	}
	
	@RequestMapping(value="**/receptionist/teacherlanguages", method=RequestMethod.GET)
	public String re_loadTeacherlanguageForm(@RequestParam("id")long id,Model model) {
		Optional<Teacher> teacher=teacherRepository.findById(id);
		Teacher t=teacher.get();
		model.addAttribute("teacher", t);
		model.addAttribute("languageList", teacherLanguageRepository.loadLanguageByTeacher(id));
		return "receptionist_addLanguageTeacher";
	}
	
	@RequestMapping(value="**/receptionist/update-updateTeacherLanguage",method=RequestMethod.POST)
	public String updateTeacherLanguage(@ModelAttribute("teacher") Teacher teacher,@RequestParam("teacherlanguage")long languageId) {
		TeacherLanguage tl=new TeacherLanguage();
		Language language=new Language();
		language.setId(languageId);
		tl.setTeacher(teacher);
		tl.setLanguage(language);
		teacherLanguageRepository.save(tl);
		return "redirect:receptionist/teachers";
		
	}
	
	@RequestMapping(value="**/manager/update-updateTeacherLanguage",method=RequestMethod.POST)
	public String managerupdateTeacherLanguage(@ModelAttribute("teacher") Teacher teacher,@RequestParam("teacherlanguage")long languageId) {
		TeacherLanguage tl=new TeacherLanguage();
		Language language=new Language();
		language.setId(languageId);
		tl.setTeacher(teacher);
		tl.setLanguage(language);
		teacherLanguageRepository.save(tl);
		return "redirect:manager/teachers";
		
	}

	
	/*@RequestMapping(value="/getTeacherByLanguage/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<HashMap<String, List<Teacher>>> getTeacherByLanguage(@PathVariable("id")Long id){
		List<Teacher> teacher=teacherLanguageRepository.loadTeacherByLanguage(id);
		
		//JSONObject item=new JSONObject();
	//HashMap item=new HashMap();
	//item.put("it", teacher);
		
	return new ResponseEntity<>( item, HttpStatus.OK);
		
		
	}
	*/

}
