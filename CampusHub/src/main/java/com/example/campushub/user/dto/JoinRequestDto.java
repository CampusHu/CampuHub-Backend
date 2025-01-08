package com.example.campushub.user.dto;

import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.constraints.NotBlank;

import com.example.campushub.user.domain.Role;
import com.example.campushub.user.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {

	@NotBlank(message = "학번을 입력해주세요")
	private String userNum;
	@NotBlank(message = "비밀번호를 입력해주세요")
	private String password;
	// @NotBlank(message = "닉네임을 입력해주세요")
	// private String nickname;

	@Builder
	public JoinRequestDto(String userNum, String password) {
		this.userNum = userNum;
		this.password = password;
	}

	public void passwordEncryption(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(this.password);
	}

	public User toEntity() {
		return User.builder()
			.userNum(userNum)
			.password(password)
			.role(Role.USER)
			.build();
	}
}