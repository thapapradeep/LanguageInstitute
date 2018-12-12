package com.soft.app.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Role;
import com.soft.app.repository.RoleReopsitory;

@Controller
public class RoleController {
	
	@Autowired private RoleReopsitory roleRepository;
	
	
	@ModelAttribute("role")
   private Role getRole() {
		return new Role();
	}
	
	@RequestMapping(value="**/admin/addRole")
	private String loadRoleForm() {
		return "admin_addRole";
		
	}
	
	@RequestMapping(value="**/add-addRole", method=RequestMethod.POST)
	private String addRole(@ModelAttribute("role")Role role) {
		roleRepository.save(role);
		return "redirect:/viewRole";
	}
	
	@RequestMapping(value="**/admin/viewRole", method=RequestMethod.GET)
	private String admin_viewRole(Model model) {
		model.addAttribute("roleList",roleRepository.findAll());
		return "admin_viewRole";
	}
	
	@RequestMapping(value="**/manager/viewRoles", method=RequestMethod.GET)
	private String manager_viewRole(Model model) {
		model.addAttribute("roleList",roleRepository.findAll());
		return "manager_viewRole";
	}
	
	
	
	@RequestMapping(value="**/admin/updateRoles", method=RequestMethod.GET)
	private String loadUpdateRolePage(@RequestParam("id") long id, Model model) {
	
		Optional<Role> role=roleRepository.findById(id);
		Role r=role.get();
		model.addAttribute("role", r);
		
		return "admin_updateRole";
	}
	
	@RequestMapping(value="**/admin/update-updateRole", method=RequestMethod.POST)
	private String updateRole(@ModelAttribute("role")Role role) {
		roleRepository.save(role);
		
		return"redirect:admin/viewRole";
		
	}
	
	@RequestMapping(value="**/admin/deleteRole", method=RequestMethod.GET)
	private String deleteRole(@RequestParam("id") long id) {
		roleRepository.deleteById(id);
		return"redirect:admin/viewRole";
	}
	
}
