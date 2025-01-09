package com.example.campushub.user.repository;

import java.util.List;
import java.util.Optional;

import com.example.campushub.user.domain.Status;
import com.example.campushub.user.dto.UserResponseDto;
import com.example.campushub.user.dto.UsersResponseDto;

public interface UserRepositoryCustom {

	List<UsersResponseDto> getUsers(String username, String deptName, String userNum, Status status);

	Optional<UserResponseDto> getUserByUserNum(String userNum);
}
