package org.ssglobal.training.codes.security.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.User;
import org.ssglobal.training.codes.response.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> login(@RequestBody User user) {
		return ResponseEntity.ok(authService.login(user));
	}
}
