package com.soft.app.service;

import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired private JavaMailSender mailSender;
	@Autowired private MessageSource messageSource;
	
	@Async
	public void send(String subject,String content,String to)throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress(messageSource.getMessage("from",null, Locale.ROOT)));
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(content,"utf-8","html");
		mailSender.send(mimeMessage);
	}
}
