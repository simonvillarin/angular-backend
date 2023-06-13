package org.ssglobal.training.codes.security.auth;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.User;
import org.ssglobal.training.codes.repository.UserRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.security.config.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public Response register(User user) {
		User _user = User.builder()
				.firstName(user.getFirstName())
				.middleName(user.getMiddleName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.birthdate(user.getBirthdate())
				.listOfInterest(user.getListOfInterest())
				.house(user.getHouse())
				.building(user.getBuilding())
				.street(user.getStreet())
				.barangay(user.getBarangay())
				.city(user.getCity())
				.province(user.getProvince())
				.zipcode(user.getZipcode())
				.username(user.getUsername())
				.phoneNumber(user.getPhoneNumber())
				.password(passwordEncoder.encode(user.getPassword()))
				.role(user.getRole())
				.status(user.getStatus())
				.build();
		
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
		userRepository.save(_user);
		return Response.builder()
				.statusCode(201)
				.message("User successfully added")
				.timestamp(LocalDateTime.now())
				.build();
	}
	
	public TokenResponse login(User user) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		String token;
		Optional<User> userOpt = userRepository.findByUsername(user.getUsername());
		if (userOpt.isPresent()) {
			token = jwtService.generateToken(userOpt.get());
		} else {
			throw new RuntimeException("User not found");
		}
		return TokenResponse.builder()
				.token(token)
				.userId(userOpt.get().getUserId())
				.role(userOpt.get().getRole())
				.status(userOpt.get().getStatus())
				.build();
	}
}
