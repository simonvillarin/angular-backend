package org.ssglobal.training.codes.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.dao.UserDao;
import org.ssglobal.training.codes.model.User;
import org.ssglobal.training.codes.repository.UserRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public List<UserDao> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDao> usersDao = new ArrayList<>();
		
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserDao userDao = UserDao.builder()
					.userId(user.getUserId())
					.firstName(user.getFirstName())
					.middleName(user.getMiddleName())
					.lastName(user.getLastName())
					.birthdate(user.getBirthdate())
					.listOfInterest(user.getListOfInterest())
					.house(user.getHouse())
					.building(user.getBuilding())
					.street(user.getStreet())
					.barangay(user.getBarangay())
					.city(user.getCity())
					.province(user.getProvince())
					.zipcode(user.getZipcode())
					.email(user.getEmail())
					.phoneNumber(user.getPhoneNumber())
					.username(user.getUsername())
					.password(user.getPassword())
					.role(user.getRole())
					.status(user.getStatus())
					.build();
			usersDao.add(userDao);
		}
		return usersDao;
	}

	@Override
	public UserDao getUserById(Integer userId) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			UserDao userDao = UserDao.builder()
					.userId(user.getUserId())
					.firstName(user.getFirstName())
					.middleName(user.getMiddleName())
					.lastName(user.getLastName())
					.birthdate(user.getBirthdate())
					.listOfInterest(user.getListOfInterest())
					.house(user.getHouse())
					.building(user.getBuilding())
					.street(user.getStreet())
					.barangay(user.getBarangay())
					.city(user.getCity())
					.province(user.getProvince())
					.zipcode(user.getZipcode())
					.email(user.getEmail())
					.phoneNumber(user.getPhoneNumber())
					.username(user.getUsername())
					.password(user.getPassword())
					.role(user.getRole())
					.status(user.getStatus())
					.build();
			return userDao;
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	@Override
	public Response isEmailValid(User user) {
		Optional<User> userOpt = userRepository.findByEmail(user.getEmail());
		if (userOpt.isPresent()) {
			return Response.builder()
					.statusCode(200)
					.message("Email is valid")
					.timestamp(LocalDateTime.now())
					.id(userOpt.get().getUserId())
					.build();
		} else {
			return Response.builder()
					.statusCode(404)
					.message("Email not found")
					.timestamp(LocalDateTime.now())
					.build();
		}

	}

	@Override
	public Response addUser(User user) {
		Optional<User> userOpt1 = userRepository.findByEmail(user.getEmail());
		Optional<User> userOpt2 = userRepository.findByUsername(user.getUsername());
		Optional<User> userOpt3 = userRepository.findByPhoneNumber(user.getPhoneNumber());
		
		if (userOpt1.isPresent()) {
			return Response.builder()
					.statusCode(409)
					.message("Email already exists")
					.timestamp(LocalDateTime.now())
					.build();
		} else if (userOpt2.isPresent()) {
			return Response.builder()
					.statusCode(409)
					.message("Username already exists")
					.timestamp(LocalDateTime.now())
					.build();
		} else if (userOpt3.isPresent()) {
			return Response.builder()
					.statusCode(409)
					.message("Phone number already exists")
					.timestamp(LocalDateTime.now())
					.build();
		}
		userRepository.save(user);
		return Response.builder()
				.statusCode(201)
				.message("User successfully added")
				.timestamp(LocalDateTime.now())
				.build();
	}

	@Override
	public Response updateUser(Integer userId, User user) {
		Optional<User> userOpt = userRepository.findById(userId);
		Optional<User> userOpt1 = userRepository.findByEmail(user.getEmail());
		Optional<User> userOpt2 = userRepository.findByUsername(user.getUsername());
		Optional<User> userOpt3 = userRepository.findByPhoneNumber(user.getPhoneNumber());
		
		if (userOpt.isPresent()) {
			User _user = userOpt.get();
			if (user.getFirstName() != null) {
				_user.setFirstName(user.getFirstName());
			}
			if (user.getMiddleName() != null) {
				_user.setMiddleName(user.getMiddleName());
			}
			if (user.getLastName() != null) {
				_user.setLastName(user.getLastName());
			}
			if (user.getBirthdate() != null) {
				_user.setBirthdate(user.getBirthdate());
			}
			if (user.getListOfInterest() != null) {
				_user.setListOfInterest(user.getListOfInterest());
			}
			if (user.getHouse() != null ) {
				_user.setHouse(user.getHouse());
			}
			if (user.getBuilding() != null ) {
				_user.setBuilding(user.getBuilding());
			}
			if (user.getStreet() != null ) {
				_user.setStreet(user.getStreet());
			}
			if (user.getBarangay() != null ) {
				_user.setBarangay(user.getBarangay());
			}
			if (user.getCity() != null ) {
				_user.setCity(user.getCity());
			}
			if (user.getProvince() != null ) {
				_user.setProvince(user.getProvince());
			}
			if (user.getZipcode() != null ) {
				_user.setZipcode(user.getZipcode());
			}
			if (user.getEmail() != null) {
				_user.setEmail(user.getEmail());;
			}
			if (user.getPhoneNumber() != null) {
				_user.setPhoneNumber(user.getPhoneNumber());
			}
			if (user.getUsername() != null) {
				_user.setUsername(user.getUsername());
			}
			if (user.getPassword() != null) {
				_user.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			if (user.getRole() != null) {
				_user.setRole(user.getRole());
			}
			if (user.getStatus() != null) {
				_user.setStatus(user.getStatus());;
			}
			
			if (userOpt1.isPresent()) {
				return Response.builder()
						.statusCode(409)
						.message("Email already exists")
						.timestamp(LocalDateTime.now())
						.build();
			} else if (userOpt2.isPresent()) {
				return Response.builder()
						.statusCode(409)
						.message("Username already exists")
						.timestamp(LocalDateTime.now())
						.build();
			} else if (userOpt3.isPresent()) {
				return Response.builder()
						.statusCode(409)
						.message("Phone number already exists")
						.timestamp(LocalDateTime.now())
						.build();
			}
			userRepository.save(_user);
			return Response.builder()
					.statusCode(200)
					.message("User successfully updated")
					.timestamp(LocalDateTime.now())
					.build();
		} else {
			throw new RuntimeException("User not found");
		}
	}

	@Override
	public Response deleteUser(Integer userId) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			userRepository.deleteById(userId);
			return Response.builder()
					.statusCode(200)
					.message("User successfully deleted")
					.timestamp(LocalDateTime.now())
					.build();
		} else {
			return Response.builder()
					.statusCode(404)
					.message("User not found")
					.timestamp(LocalDateTime.now())
					.build();
		}
	}
}
