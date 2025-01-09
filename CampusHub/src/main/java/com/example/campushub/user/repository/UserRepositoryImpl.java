package com.example.campushub.user.repository;

import static com.example.campushub.dept.domain.QDept.*;
import static com.example.campushub.user.domain.QUser.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.user.domain.Status;
import com.example.campushub.user.dto.QUserResponseDto;
import com.example.campushub.user.dto.QUsersResponseDto;
import com.example.campushub.user.dto.UserResponseDto;
import com.example.campushub.user.dto.UsersResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//학생 조건 조회
	@Override
	public List<UsersResponseDto> getUsers(String username,String deptName, String userNum, Status status) {
		return queryFactory.select(new QUsersResponseDto(
			user.id,
			user.userName,
			user.userNum,
			user.dept.deptName,
			user.type,
			user.status
		))
			.from(user)
			.join(dept).on(dept.id.eq(user.dept.id))
			.where(user.userName.eq(username))
			.where(user.userNum.eq(userNum))
			.where(user.status.eq(status))
			.where(user.dept.deptName.eq(deptName))
			.fetch();
	}

	// 단건조회
	@Override
	public Optional<UserResponseDto> getUserByUserNum(String userNum) {
		UserResponseDto fetchOne = queryFactory.select(new QUserResponseDto(
			user.userNum,
			user.userName,
			user.birthday,
			user.dept.deptName,
			user.grade,
			user.email,
			user.phone,
			user.address
		))
			.from(user)
			.join(dept).on(dept.id.eq(user.dept.id))
			.where(user.userNum.eq(userNum))
			.fetchOne();
		return Optional.ofNullable(fetchOne);
	}

}
