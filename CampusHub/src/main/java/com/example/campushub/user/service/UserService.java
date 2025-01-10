package com.example.campushub.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.user.domain.Status;
import com.example.campushub.user.dto.StatusUserDto;
import com.example.campushub.user.dto.UserSearchCondition;
import com.example.campushub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;

	//조건조회
	public List<StatusUserDto> getUserByCondition(UserSearchCondition condition) {
		return userRepository.getUserByCondition(condition);
	}

}
