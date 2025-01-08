package com.example.campushub.user.dto;


import com.example.campushub.user.domain.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginUser {
	private String userNum;
	private Role role;

	@Builder
	public LoginUser(String userNum, Role role) {
		this.userNum = userNum;
		this.role = role;
	}
}
