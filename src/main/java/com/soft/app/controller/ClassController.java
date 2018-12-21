package com.soft.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.soft.app.repository.ClassRoutineReopsitory;
import com.soft.app.repository.ClassesRepository;
import com.soft.app.repository.LanguageRepository;
import com.soft.app.repository.TeacherLanguageRepository;
import com.soft.app.repository.TeacherRepository;


@Controller
@CrossOrigin(allowedHeaders = "*")
public class ClassController {
	@Autowired private ClassesRepository classRepository;
	@Autowired private BatchRepository batchRepository;
	@Autowired private LanguageRepository languageRepository;
	@Autowired private TeacherRepository teacherRepository;
	@Autowired private TeacherLanguageRepository teacherLanguageRepo;
	@Autowired private ClassRoutineReopsitory classsRoutineRepository;
	
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
	private String manager_addClass(@ModelAttribute("clas") classes clas) throws Exception {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	        Date date =new Date(); 
	        Date date1=dateFormat.parse(dateFormat.format(date));
	       clas.setDate(date1);
	       clas.setStatus("enabled");
		classRepository.save(clas);
		return "redirect:manager/viewClasses";
		
	}
	@RequestMapping(value="**/receptionist/add-addClass", method=RequestMethod.POST)
	private String receptionistaddClass(@ModelAttribute("clas") classes clas)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       clas.setDate(date1);
       clas.setStatus("enabled");
	classRepository.save(clas);
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
	
	@RequestMapping(value="**/receptionist/viewTodayClasses", method=RequestMethod.GET)
	private String re_loadTodayClasses(Model model, Model model1) {
		Calendar calendar=Calendar.getInstance();
		int day=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		model.addAttribute("classList", classsRoutineRepository.getRoutineByDay(new Long(day),new Long(1)));
		model1.addAttribute("classList1", classsRoutineRepository.getRoutineByDay(new Long(day),new Long(7)));
		return "receptionist_todayClass";
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
	private String loadUpdateClassForm( @RequestParam("id")Long id, Model model, Model model1, Model model2, Model model3) {
      Optional<classes> clas=classRepository.findById(id);
      classes c=clas.get();
      model.addAttribute("clas", c);
      model1.addAttribute("languageList", languageRepository.findAll());
      model3.addAttribute("teacherList", teacherRepository.findAll());
      model2.addAttribute("batchList", batchRepository.findAll());
      
	return "manager_updateClass";
		
		
	}
	@RequestMapping(value="**/receptionist/updateClass", method=RequestMethod.GET)
	private String rec_loadUpdateClassForm( @RequestParam("id")Long id, Model model, Model model1, Model model2, Model model3) {
      Optional<classes> clas=classRepository.findById(id);
      classes c=clas.get();
      model.addAttribute("clas", c);
      model1.addAttribute("teacherList", teacherRepository.findAll());
      model2.addAttribute("languageList", languageRepository.findAll());
      model3.addAttribute("batchList", batchRepository.findAll());
      
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
	@RequestMapping(value="**/manager/viewStudentBatch",method=RequestMethod.GET)
	public String m_viewBatchStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("studentList", classRepository.getStudentByBatch(id));
		return "manager_viewBatchStudent";
	}
	
	@RequestMapping(value="**/accountant/viewStudentBatch",method=RequestMethod.GET)
	public String a_viewBatchStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("studentlist", classRepository.getStudentByBatch(id));
		return "accountant_viewStudent";
	}
	
	
	@RequestMapping(value="**/manager/viewClassBatch",method=RequestMethod.GET)
	public String ma_viewBatchStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("classList", classRepository.getClassByBatch(id));
		return "manager_viewBatchClass";
	}
	
	@RequestMapping(value="**/accountant/viewClassBatch",method=RequestMethod.GET)
	public String acc_viewBatchStudent(@RequestParam("id")Long id, Model model) {
		model.addAttribute("ClassList", classRepository.getClassByBatch(id));
		return "accountant_viewClass";
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
	

	@RequestMapping(value="/viewNoOfStudentsPerClassOct", method=RequestMethod.GET)
	public @ResponseBody List<classes> getNoOFStudents() {
		try {
			List<classes> cinfo = classRepository.getNumberOfStudentsOct();
			return cinfo;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
			
		}
		
	}
	@RequestMapping(value="/viewNoOfStudentsPerClassNov", method=RequestMethod.GET)
	public @ResponseBody List<classes> getNoOFStudentsNov() {
		try {
			List<classes> cinfo = classRepository.getNumberOfStudentsNov();
			return cinfo;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
			
		}
		
	}
	
}
