package com.example.campushub.user.repository;

import java.util.List;
import java.util.Optional;

import com.example.campushub.user.dto.UserResponseDto;
import com.example.campushub.user.dto.StatusUserDto;
import com.example.campushub.user.dto.UserSearchCondition;

public interface UserRepositoryCustom {
	//복학대기학생조회
	List<StatusUserDto> getUserByCondition(UserSearchCondition searchCondition);
	//단건조회
	Optional<UserResponseDto> getUserByUserNum(String userNum);
	//전체조회

}
 // (휴학대기학생조회, 학생 전체 조회, 교수 전체 조회, 교수 단건조회) 제작, 리스폰스 디티오 이름 제정의 필요