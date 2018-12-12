package com.soft.app.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.soft.app.model.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user=(User) target;
		
		if(user.getFirstname().equals("") || user.getFirstname()==null) {
			errors.rejectValue("firstname","firstname.empty");
		}
		else if(!isFirstnameValid(user.getFirstname())) {
			errors.rejectValue("firstname", "firstname.invalid");
		}
		
		if(user.getLastname().equals("") || user.getLastname()==null) {
			errors.rejectValue("lastname","lastname.empty");
		}
		else if(!isFirstnameValid(user.getLastname())) {
			errors.rejectValue("lastname", "lastname.invalid");
		}
		
		if(user.getEmail().equals("") || user.getEmail()==null) {
			errors.rejectValue("email", "email.empty");
		}
		else if(!isEmailValid(user.getEmail())) {
			errors.rejectValue("email", "email.invalid");
		}
		if(user.getAddress().equals("") || user.getAddress()==null) {
			errors.rejectValue("address", "address.empty");
		}
		if(user.getPassword().equals("") || user.getPassword()==null) {
			errors.rejectValue("password", "password.empty");
		}
		else if(!isPasswordValid(user.getPassword())) {
			errors.rejectValue("password", "password.invalid");
		}
		
		if(user.getContactnumber().equals("") || user.getContactnumber()==null) {
			errors.rejectValue("contactnumber", "contact.empty");
		}
		else if(!isContactValid(user.getContactnumber())) {
			errors.rejectValue("contactnumber", "contact.invalid");
		}


		
		
	}
	
	private boolean isFirstnameValid(String firstname) {
		String firstnameExp;
		Pattern pattern;
		firstnameExp="^[A-Za-z]+$";
		pattern=Pattern.compile(firstnameExp);
		Matcher matcher=pattern.matcher(firstname);
		if(!matcher.find()) {
			return false;
		}
		return true;
	}
	
	private boolean isEmailValid(String email) {
		String emailExp;
		Pattern pattern;
		emailExp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		pattern=Pattern.compile(emailExp);
		Matcher matcher=pattern.matcher(email);
		if(!matcher.find()) {
			return false;
		}
		return true;
	}
	
	private boolean isPasswordValid(String password) {
		String regExp;
		Pattern pattern;
		regExp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})";
		pattern=Pattern.compile(regExp);
		Matcher matcher=pattern.matcher(password);
		if(!matcher.find()) {
			return false;
		}
		return true;
		
		
	}
	
	private boolean isContactValid(String contact) {
		String regex;
		Pattern pattern;
		regex="^[0-9]{10}$";
		pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(contact);
		if(!matcher.find()) {
			return false;
		}
		return true;
	}

}
