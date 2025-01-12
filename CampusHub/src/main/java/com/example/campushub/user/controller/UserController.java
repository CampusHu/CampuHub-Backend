package com.example.campushub.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.campushub.global.security.Login;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.dto.UserFindAllDto;
import com.example.campushub.user.dto.UserFindOneDto;
import com.example.campushub.user.dto.UserSearchCondition;
import com.example.campushub.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	//학생 단건조회
	@GetMapping("/api/student/{userNum}")
	@ResponseStatus(HttpStatus.OK)
	public String getStudent(@Login LoginUser loginUser, @PathVariable String userNum, Model model){
		UserFindOneDto responseData = userService.getStudentByUserNum(loginUser, userNum);
		model.addAttribute("student", responseData);

		return "/user/stdent";
	}
	//학생 전체 조히
	@GetMapping("/api/students/condition")
	@ResponseStatus(HttpStatus.OK)
	public String getStudentCondition(@Login LoginUser loginUser, UserSearchCondition condition, Model model){
		List<UserFindAllDto> responseData = userService.getStudentByCondition(loginUser, condition);
		model.addAttribute("students", responseData);
		return "/user/stdents";
	}
	//교수 단건조회
	@GetMapping("/api/professor/{userNum}")
	@ResponseStatus(HttpStatus.OK)
	public String getProfessor(@Login LoginUser loginUser, @PathVariable String userNum, Model model){
		UserFindOneDto responseData = userService.getProfessorByUserNum(loginUser, userNum);
		model.addAttribute("professor", responseData);
		return "/user/professor";
	}
	//교수 전체 조회
	@GetMapping("/api/professors/condition")
	@ResponseStatus(HttpStatus.OK)
	public String getProfessorCondition(@Login LoginUser loginUser, UserSearchCondition condition, Model model){
		List<UserFindAllDto> responseData = userService.getProfessorByCondition(loginUser, condition);
		model.addAttribute("professors", responseData);
		return "/user/professors";
	}

	//학생 상태 수락(변경)
	@PostMapping("/api/student/editstatus")
	@ResponseStatus(HttpStatus.OK)
	public String updateStudentStatus(@Login LoginUser loginUser, List<String> userNums){
		userService.updateUserStatus(loginUser, userNums);
		return "redirect:/user/students";
	}
}
