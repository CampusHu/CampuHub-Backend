package com.example.campushub.user.repository;

import static com.example.campushub.dept.domain.QDept.*;
import static com.example.campushub.user.domain.QUser.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.campushub.user.domain.Status;
import com.example.campushub.user.dto.QStatusUserDto;
import com.example.campushub.user.dto.StatusUserDto;
import com.example.campushub.user.dto.QUserResponseDto;
import com.example.campushub.user.dto.UserResponseDto;
import com.example.campushub.user.dto.UserSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//사용자 컨디션 조회 및 전체 조회
	@Override
	public List<StatusUserDto> getUserByCondition(UserSearchCondition searchCondition) {
		return queryFactory.select(new QStatusUserDto(
			user.id,
			user.userName,
			user.userNum,
			user.dept.deptName,
			user.type,
			user.status
		))
			.from(user)
			.join(dept).on(dept.id.eq(user.dept.id))
			.where(statusEq(searchCondition.getStatus()),
				userNumEq(searchCondition.getUserNum()),
				deptNameEq(searchCondition.getDeptName()))
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

	private BooleanExpression statusEq(Status status) {
		return !StringUtils.hasText(status.name()) ? null : (user.status.eq(status));
	}
	private BooleanExpression userNumEq(String userNum) {
		return !StringUtils.hasText(userNum) ? null : (user.userNum.eq(userNum));
	}
	private BooleanExpression deptNameEq(String deptName) {
		return !StringUtils.hasText(deptName) ? null : (user.dept.deptName.eq(deptName));
	}

}
