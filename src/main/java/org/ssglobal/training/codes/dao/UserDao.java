package org.ssglobal.training.codes.dao;

import java.time.LocalDate;
import java.util.List;

import org.ssglobal.training.codes.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
	private Integer userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate birthdate;
	private List<String> listOfInterest;
	private String house;
	private String building;
	private String street;
	private String barangay;
	private String city;
	private String province;
	private String zipcode;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private Role role;
	private Boolean status;
}
