package com.soft.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soft.app.model.User;
import com.soft.app.repository.UserRepository;

@Component("userLoginUtil")
public class UserLoginUtil {

	@Autowired private UserRepository userRepository;
	
	public boolean checkLogin(User user) {
		
		String username=user.getEmail();
		String password=user.getPassword();
		
		User u=userRepository.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		String unDB=u.getEmail();
		System.out.println("Username "+unDB);
		
		String pwDB=u.getPassword();
		System.out.println("Password "+pwDB);
		
		if(username.equalsIgnoreCase(unDB) && password.equalsIgnoreCase(pwDB)) {
			return true;
		}else {
			return false;
		}
		
	}
}
