package org.ssglobal.training.codes.security.auth;

import org.ssglobal.training.codes.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
	private String token;
	private Integer userId;
	private Role role;
	private boolean status;
}
