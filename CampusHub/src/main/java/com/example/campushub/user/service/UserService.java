package com.example.campushub.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.dto.UserFindAllDto;
import com.example.campushub.user.dto.UserSearchCondition;
import com.example.campushub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;

	//조건조회 + 전체 조회
	public List<UserFindAllDto> getUserByCondition(UserSearchCondition condition) {
		return userRepository.findAllStudentByCondition(condition);
	}

	//학색 상태 변경
	@Transactional
	public void updateUserStatus(LoginUser loginUser, List<String> userNums) {
		//관리자 확인
		userRepository.findByUserNumAndType(loginUser.getUserNum(), "ADMIN")
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 없습니다."));

		List<User> users = userRepository.findAllByUserNums(userNums);

		for (User user : users) {
			if (!user.isSuccessStatus()){
				throw new IllegalArgumentException("ERROR");
			}
			user.updateStatus();
		}
	}

}
