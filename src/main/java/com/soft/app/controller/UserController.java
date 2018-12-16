package com.soft.app.controller;






import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.soft.app.model.Role;
import com.soft.app.model.User;
import com.soft.app.repository.ClassRoutineReopsitory;
import com.soft.app.repository.RoleReopsitory;
import com.soft.app.repository.StaffSalaryRepository;
import com.soft.app.repository.TeacherSalaryRepository;
import com.soft.app.repository.UserRepository;
import com.soft.app.util.UserLoginUtil;
import com.soft.app.validator.UserValidator;

@Controller
public class UserController {

	@Autowired private UserRepository userRepository;
	@Autowired private UserLoginUtil userLoginUtil;
	@Autowired private RoleReopsitory roleRepository;
	@Autowired private UserValidator userValidator;
	@Autowired private StaffSalaryRepository staffSalaryRepository;
	@Autowired private TeacherSalaryRepository teacherSalaryRepository;
	@Autowired private ClassRoutineReopsitory classRoutineReopsitory;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	//if url is / then this method will be mapped 
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String loadLoginPage(Model model,@ModelAttribute("user")User user){
			model.addAttribute("user",new User());
			return "login"; //returning view
		}
		
		//method to get username of the logged in user
		public String getPrincipal(){
			String username=null;
			Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(principal instanceof UserDetails){
				username=((UserDetails) principal).getUsername(); //getting username from UserDetails
			}else{
				username=null;
			}
			return username; //returning username
		}
		
		//logout url
		@RequestMapping(value="**/logout",method=RequestMethod.GET)
		public String configureLogoutAction(HttpServletRequest request,HttpServletResponse response){
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null){
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/?logout"; //redirecting to logout page
		}
		
	
	@RequestMapping(value="/usersInfo",method=RequestMethod.GET)
	public @ResponseBody List<User> allUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="**/admin",method=RequestMethod.GET)
	public String loadAdminDashboard(Model model, Model model1) {
		model.addAttribute("userList", userRepository.findAll());
		model1.addAttribute("roleList", roleRepository.findAll());
		return "admindashboard";
	}
	

	@RequestMapping(value="**/manager",method=RequestMethod.GET)
	public String loadManagerDashboard(Model model) {
		
		return "managerdashboard";
	}
	

	@RequestMapping(value="**/accountant",method=RequestMethod.GET)
	public String loadAccountantDashboard(Model model, Model model1) {
		//Calendar calendar=Calendar.getInstance();
				//int month=calendar.get(Calendar.MONTH);
				//int month1=month+1;
				model.addAttribute("staffList", staffSalaryRepository.getUnPaidStaff(10));
		model1.addAttribute("teacherList", teacherSalaryRepository.getUnPaidTeacher(10));
				return "accountantdashboard";
	}
	

	@RequestMapping(value="**/receptionist",method=RequestMethod.GET)
	public String loadReceptionistDashboard(Model model) {
		model.addAttribute("routineList", classRoutineReopsitory.findAll());
		return "receptionistdashboard";
	}
	
	
	@RequestMapping(value="**/admin/addUser",method=RequestMethod.GET)
	public String loadAddUserPage(Model model) {
		model.addAttribute("roleList", roleRepository.findAll());
		return "admin_addUsers";
	}
	
	@RequestMapping(value="**/admin/add-addUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Validated User user,BindingResult result,@RequestParam("role")long roleId,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("roleList", roleRepository.findAll());
			return "admin_addUsers";
		}
		user.setUnhashed_password(user.getPassword());
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		String encoded_password=encoder.encode(user.getPassword());
		user.setPassword(encoded_password);
		user.setStatus("Enabled");
		Role role=new Role();
		role.setId(roleId);
		user.setRole(role);
		userRepository.save(user);
		return "redirect:admin/viewUser";
	}
	
	@RequestMapping(value="**/admin/viewUser",method=RequestMethod.GET)
	public String getAllUsers(Model model){
		model.addAttribute("usersList", userRepository.findAll());
		return "admin_viewUsers";
	}
	
	@RequestMapping(value="**/admin/deleteUser",method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") long id) {
		userRepository.deleteById(id);
		return "redirect:admin/viewUser";
	}
	
	@RequestMapping(value="**/admin/updateUser",method=RequestMethod.GET)
	public String loadUpdatePage(@RequestParam("id") long id,Model model) {
		Optional<User> user=userRepository.findById(id);
		User u=user.get();
		model.addAttribute("user", u);
		return "admin_updateUsers";
	}
	
	@RequestMapping(value="**/admin/update-updateUser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user) {
		user.setStatus("Enabled");
		userRepository.save(user);
		return "redirect:admin/viewUser";
	}
	
	@RequestMapping(value="**/login-loginaction", method=RequestMethod.POST)
	public String doLogin(@ModelAttribute("user")User user) {
		try {
		if(userLoginUtil.checkLogin(user)) {
			return "redirect:/admindashboard";
		}
		}catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
			return "redirect:/";
			
		}
		return "redirect:/";
		}
	
	
}
