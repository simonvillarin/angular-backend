package org.ssglobal.training.codes.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name", length = 80)
	private String firstName;
	
	@Column(name = "middle_name", length = 80)
	private String middleName;
	
	@Column(name = "last_name", length = 80)
	private String lastName;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;
	
	@Column(name = "list_of_interest")
	private List<String> listOfInterest;
	
	@Column(name = "house")
	private String house;
	
	@Column(name = "building")
	private String building;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "barangay")
	private String barangay;
	 
	@Column(name = "city")
	private String city;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "email", length = 80)
	private String email;
	
	@Column(name = "phone_number", length = 80)
	private String phoneNumber;
	
	@Column(name = "username", length = 80)
	private String username;
	
	@Column(name = "password", length = 80)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "status")
	private Boolean status;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return status;
	}

	@Override
	public boolean isAccountNonLocked() {
		return status;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return status;
	}

	@Override
	public boolean isEnabled() {
		return status;
	}
}
