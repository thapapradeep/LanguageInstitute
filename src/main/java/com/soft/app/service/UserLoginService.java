package com.soft.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soft.app.model.Role;
import com.soft.app.model.User;
import com.soft.app.repository.UserRepository;

@Service
public class UserLoginService implements UserDetailsService{

	@Autowired private UserRepository userRepo;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.getUserByUsername(username);
		List<GrantedAuthority> authorities=configureAuthority(user.getRole());
		if(authorities==null){
			System.out.println("Role is null");
		}
		return configureUserForAuthentication(user, authorities);
		
	}

	//this private method will authenticate user by users username,password and roles
	private org.springframework.security.core.userdetails.User configureUserForAuthentication
	(User user,List<GrantedAuthority> authorities){
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> configureAuthority(Role role){
		Set<GrantedAuthority> ga=new HashSet<GrantedAuthority>();
		ga.add(new SimpleGrantedAuthority(role.getRole()));
		
		List<GrantedAuthority> authority=new ArrayList<GrantedAuthority>(ga);
		return authority;
	}

}
