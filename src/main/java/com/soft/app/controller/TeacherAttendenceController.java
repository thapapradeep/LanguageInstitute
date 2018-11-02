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
import com.soft.app.model.Teacher;
import com.soft.app.model.TeacherAttendence;
import com.soft.app.repository.TeacherAttendenceRepository;
import com.soft.app.repository.TeacherRepository;



@Controller
public class TeacherAttendenceController {

	@Autowired TeacherAttendenceRepository teacherAttendenceReposiory;
	@Autowired TeacherRepository teacherRepository;
	
	@ModelAttribute("teacherAttendence")
	private TeacherAttendence getstaffAttendence() {
		return new TeacherAttendence();
	}
	
	
	@RequestMapping(value="**/receptionist/teacherAttendences", method=RequestMethod.GET)
	private String loadTeacherAttendence(Model model) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
		model.addAttribute("teacherList", teacherRepository.getTeacherByDate(date1));
		return "receptionist_teacherAttendence";
}
	@RequestMapping(value="**//present-Teacher", method=RequestMethod.GET)
	private String presentTeacher(@RequestParam("id") Long id) throws Exception {
		Teacher teacher=new Teacher();
		teacher.setId(id);
		TeacherAttendence ta=new TeacherAttendence();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       ta.setDate(date1);
		ta.setTeacher(teacher);
		ta.setStatus("Present");
		teacherAttendenceReposiory.save(ta);
		return "redirect:receptionist/teacherAttendences";
	}

	@RequestMapping(value="**/absent-Teacher", method=RequestMethod.GET)
	private String absentTeacher(@RequestParam("id") Long id) throws Exception{
		Teacher teacher=new Teacher();
		teacher.setId(id);
		TeacherAttendence ta=new TeacherAttendence();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       ta.setDate(date1);
		ta.setTeacher(teacher);
		ta.setStatus("Absent");
		teacherAttendenceReposiory.save(ta);
		return "redirect:receptionist/teacherAttendences";
	}
	
	@RequestMapping(value="**/manager/viewTeacherAttencence")
	public String loadTeacherAttendenceHistory(@RequestParam("id")Long id,Model model) {
		model.addAttribute("teacherAttendenceList", teacherAttendenceReposiory.getteacherAttendenceHistory(id));
		return "manager_viewTeacherAttendence";
	}
}
