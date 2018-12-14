package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Staff;
import com.soft.app.model.StaffAttendence;
import com.soft.app.repository.StaffAttendenceReopsitory;
import com.soft.app.repository.StaffRepository;

@Controller
public class StaffAttendenceController {

@Autowired StaffAttendenceReopsitory staffAttendenceReposiory;
@Autowired StaffRepository staffRepository;

@ModelAttribute("staffAttendence")
private StaffAttendence getstaffAttendence() {
	return new StaffAttendence();
}

@RequestMapping(value="**/receptionist/staffAttendences", method=RequestMethod.GET)
private String loadStaffAttendence(Model model) {
	model.addAttribute("staffList", staffRepository.findAll());
	return "receptionist_staffAttendence";
	
}

@RequestMapping(value="**/present-Staff", method=RequestMethod.GET)
private String presentStaff(@RequestParam("id") Long id) {
	Staff staff=new Staff();
	staff.setId(id);
	StaffAttendence sa=new StaffAttendence();
	sa.setStaff(staff);
	sa.setStatus("Present");
	staffAttendenceReposiory.save(sa);
	return "redirect:/receptionist/staffAttendences";
}

@RequestMapping(value="**/absent-Staffs", method=RequestMethod.GET)
private String absentStaff(@RequestParam("id") Long id) {
	Staff staff=new Staff();
	staff.setId(id);
	StaffAttendence sa=new StaffAttendence();
	sa.setStaff(staff);
	sa.setStatus("Absent");
	staffAttendenceReposiory.save(sa);
	return "redirect:/receptionist/staffAttendences";
}

@RequestMapping(value="**/manager/viewStaffAttendence")
public String loadStaffAttendenceHistory(@RequestParam("id")Long id,Model model) {
	model.addAttribute("staffList", staffAttendenceReposiory.getStaffAttendenceHistory(id));
	return "manager_viewStaffAttendence";
}

}
