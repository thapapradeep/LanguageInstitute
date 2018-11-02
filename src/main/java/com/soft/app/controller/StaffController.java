package com.soft.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Staff;
import com.soft.app.repository.RoleReopsitory;
import com.soft.app.repository.StaffRepository;
import com.soft.app.repository.StaffSalaryRepository;

@Controller
public class StaffController {
	
	@Autowired private StaffRepository staffrepository;
	@Autowired private RoleReopsitory roleRepository;
	@Autowired private StaffSalaryRepository staffSalary;
	
	@ModelAttribute("staff")
	private Staff getStaff() {
		return new Staff();
		
	}
	
	@RequestMapping(value="**/receptionist/addStaffs")
	private String loadAddStaffPage(Model model) {
		model.addAttribute("roleList", roleRepository.findAll());
		return "receptionist_addStaff";
	}
	
	@RequestMapping(value="**/receptionist/add-addStaff" ,method=RequestMethod.POST)
	private String addStaff(@ModelAttribute("Staff")Staff staff) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date =new Date(); 
        Date date1=dateFormat.parse(dateFormat.format(date));
       staff.setDate(date1);
       staff.setStatus("enabled");
		staffrepository.save(staff);
		return "redirect:/receptionist/viewStaffs";
	}
	
	@RequestMapping(value="**/receptionist/viewStaffs", method=RequestMethod.GET)
	private String re_loadViewStaff(Model model) {
		model.addAttribute("staffList", staffrepository.findAll());
		return "receptionist_viewStaff";
		}
	
	@RequestMapping(value="**/manager/viewStaffs", method=RequestMethod.GET)
	private String loadViewStaff(Model model) {
		model.addAttribute("staffList", staffrepository.findAll());
		return "manager_viewStaff";
	}
		@RequestMapping(value="**/accountant/viewStaffs", method=RequestMethod.GET)
		private String loadViewAccountantStaff(Model model) {
			Calendar calendar=Calendar.getInstance();
			int month=calendar.get(Calendar.MONTH);
			int month1=month+1;
			model.addAttribute("staffList", staffSalary.getUnPaidStaff(month1));
			return "accountant_viewStaff";
	}
		@RequestMapping(value="**/accountant/viewPaidStaffs", method=RequestMethod.GET)
		private String p_loadViewAccountantStaff(Model model) {
			Calendar calendar=Calendar.getInstance();
			int month=calendar.get(Calendar.MONTH);
			int month1=month+1;
			model.addAttribute("staffList", staffSalary.getPaidStaff(month1));
			return "accountant_viewPaidStaff";
	}
		
		@RequestMapping(value="**/admin/viewStaffs", method=RequestMethod.GET)
		private String ad_loadViewAccountantStaff(Model model) {
			model.addAttribute("staffList", staffrepository.findAll());
			return "admin_viewStaff";
	}
	
	@RequestMapping(value="**/manager/updateStaff", method=RequestMethod.GET)
	private String loadStaffUpdateForm(@RequestParam("id") Long id, Model model) {
		Optional<Staff> staff=staffrepository.findById(id);
		Staff st=staff.get();
		model.addAttribute("staff", st);
		return "manager_updateStaff";
		
		
	}
	@RequestMapping(value="**/receptionist/updateStaff", method=RequestMethod.GET)
	private String re_loadStaffUpdateForm(@RequestParam("id") Long id, Model model) {
		Optional<Staff> staff=staffrepository.findById(id);
		Staff st=staff.get();
		model.addAttribute("staff", st);
		return "receptionist_updateStaff";
		
		
	}
	
	@RequestMapping(value="**/manager/update-updateStaff", method=RequestMethod.POST)
	private String ma_updateStaff(@ModelAttribute("staff")Staff staff) {
		staffrepository.save(staff);
		return "redirect:manager/viewStaffs";
	}
	
	@RequestMapping(value="**/receptionist/update-updateStaff", method=RequestMethod.POST)
	private String updateStaff(@ModelAttribute("staff")Staff staff) {
		staffrepository.save(staff);
		return "redirect:receptionist/viewStaffs";
	}
	@RequestMapping(value="**/manager/deleteStaffs", method=RequestMethod.GET)
	private String deleteStaff(@RequestParam("id")Long id) {
		staffrepository.deleteById(id);
		return "redirect:manager/viewStaffs";
	}

}
