package com.soft.app.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soft.app.model.CustomResponse;
import com.soft.app.model.MessageInfo;
import com.soft.app.service.EmailService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="http://localhost:8080/")
public class MessageController {

	@Autowired private EmailService emailService;
	@Autowired private VelocityEngine velocityEngine;
	@Autowired private MessageSource messageSource;
	
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public CustomResponse sendMessage(@RequestBody MessageInfo messageInfo){
		CustomResponse response = new CustomResponse();
		try {
			String name = messageInfo.getName();
			String email = messageInfo.getEmail();
			String content = messageInfo.getMessage();
			Map<String, String> model = new HashMap<>();
			model.put("email", email);
			model.put("name", name);
			model.put("paymentMessage", content);
			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email-templates/student_fee_payment.vm","UTF-8", model);
			emailService.send(messageSource.getMessage("student_fee_payment.subject",null, Locale.ROOT), text, email);
			response.setStatus(200);
			response.setMessage("Success");
			return response;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			response.setStatus(500);
			response.setMessage("Failed");
			return response;
		}
	}
	
	
}
