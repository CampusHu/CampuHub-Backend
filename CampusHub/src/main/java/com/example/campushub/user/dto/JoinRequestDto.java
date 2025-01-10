package com.example.campushub.user.dto;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.constraints.NotBlank;

import com.example.campushub.dept.domain.Dept;
import com.example.campushub.user.domain.Grade;
import com.example.campushub.user.domain.Role;
import com.example.campushub.user.domain.Status;
import com.example.campushub.user.domain.Type;
import com.example.campushub.user.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {

	@NotBlank(message = "이름을 입력하세요")
	private String userName;
	@NotBlank(message = "생년월일을 입력하세요")
	private LocalDateTime birthday;
	@NotBlank(message = "학과를 선택하세요")
	private Dept dept;
	@NotBlank(message = "이메일을 입력하세요")
	private String email;
	@NotBlank(message = "연락처를 입력하세요")
	private String phone;
	@NotBlank(message = "주소를 입력하세요")
	private String address;
	@NotBlank(message = "학번을 입력해주세요")
	private String userNum;
	@NotBlank(message = "비밀번호를 입력해주세요")
	private String password;

	@Builder
	public JoinRequestDto(String userName, LocalDateTime birthday, Dept dept, String email, String phone, String address, String userNum, String password) {
		this.userName = userName;
		this.birthday = birthday;
		this.dept = dept;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userNum = userNum;
		this.password = "1234"; //this.password = password;
	}

	public void passwordEncryption(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(this.password);
	}

	public User toEntity() {
		return User.builder()
			.userName(userName)
			.birthday(birthday)
			.dept(dept)
			.email(email)
			.phone(phone)
			.address(address)
			.userNum(userNum)
			.password(password)
			.role(Role.USER)
			.type(Type.STUDENT)
			.grade(Grade.FIRST_GRADE)
			.status(Status.ENROLLED)
			.build();
	}
}