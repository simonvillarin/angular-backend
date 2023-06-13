package org.ssglobal.training.codes.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Email;


@Service
public class EmailServiceImpl {
	@Autowired
	private JavaMailSender mailSender;
	
	 @Value("${spring.mail.username}") 
	 private String sender;
	
	public Integer sendEmail(Email email) {
		 Random random = new Random();
	     int randomNumber = random.nextInt(900000) + 100000;
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(sender);
			message.setTo(email.getTo());
			message.setText("Your OTP code for resetting your password is: " + randomNumber);
			message.setSubject("OTP code");
			mailSender.send(message);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return randomNumber;
	}
}
