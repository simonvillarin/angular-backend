package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.dao.UserDao;
import org.ssglobal.training.codes.model.User;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
	
	private final UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDao>> getAllUsers() {
		return ResponseEntity.ok(userServiceImpl.getAllUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDao> getUserById(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(userServiceImpl.getUserById(userId));
	}
	
	@PostMapping("/auth/user/email")
	public ResponseEntity<Response> isEmailValid(@RequestBody User user) {
		return ResponseEntity.ok(userServiceImpl.isEmailValid(user));
	}
	
	@PostMapping("/user")
	public ResponseEntity<Response> addUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.addUser(user));
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable("id") Integer userId, @RequestBody User user) {
		return ResponseEntity.ok(userServiceImpl.updateUser(userId, user));
	}
	
	@PutMapping("/auth/user/{id}")
	public ResponseEntity<Response> updateUser1(@PathVariable("id") Integer userId, @RequestBody User user) {
		return ResponseEntity.ok(userServiceImpl.updateUser(userId, user));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(userServiceImpl.deleteUser(userId));
	}
}
