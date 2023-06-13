package org.ssglobal.training.codes.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.Email;
import org.ssglobal.training.codes.service.impl.EmailServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class EmailController {

	private final EmailServiceImpl emailServiceImpl;
	
	@PostMapping("/email")
	public Integer sendEmail(@RequestBody Email email) {
		return emailServiceImpl.sendEmail(email);
	}
}
