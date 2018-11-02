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
import com.soft.app.model.Language;
import com.soft.app.repository.LanguageRepository;

@Controller
public class LanguageController {
	
	@Autowired private LanguageRepository languageRepository;
	
	@ModelAttribute("language")
	public Language getLanguage() {
		return new Language();
	}
	
	@RequestMapping(value="**/receptionist/addLanguage")
	public String loadLanguageForm() {
		return"receptionist_addLanguage";
	}
	@RequestMapping(value="**/manager/addLanguage")
	public String manager_loadLanguageForm() {
		return"manager_addLanguage";
	}
	
	@RequestMapping(value="**/receptionist/add-addLanguage", method=RequestMethod.POST)
	public String saveLanguage(@ModelAttribute("language")Language language) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       language.setDate(date1);
       language.setStatus("enabled");
		languageRepository.save(language);
		return "redirect:receptionist/viewLangauges";
	}
	
	@RequestMapping(value="**/manager/add-addLanguage", method=RequestMethod.POST)
	public String manager_saveLanguage(@ModelAttribute("language")Language language)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       language.setDate(date1);
       language.setStatus("enabled");
		languageRepository.save(language);
		return "redirect:manager/viewLangauges";
	}
	
	@RequestMapping(value="**/receptionist/viewLangauages" , method=RequestMethod.GET)
	public String viewAllLanguage(Model model) {
		model.addAttribute("languagelist", languageRepository.findAll());
		return "receptionist_viewLanguage";
		
	}
	
	@RequestMapping(value="**/accountant/viewLangauages" , method=RequestMethod.GET)
	public String ac_viewAllLanguage(Model model) {
		model.addAttribute("languagelist", languageRepository.findAll());
		return "accountant_viewLanguage";
	}
	
	@RequestMapping(value="**/manager/viewLangauages" , method=RequestMethod.GET)
	public String manager_viewAllLanguage(Model model) {
		model.addAttribute("languagelist", languageRepository.findAll());
		return "manager_viewLanguage";
		
	}
	
	@RequestMapping(value="**/deleteLanguages", method=RequestMethod.GET)
	public String deleteLanguage(@RequestParam("id") long id) {
		languageRepository.deleteById(id);
		return "redirect:manager/viewLangauges";
		
	}
	
	

}
