package com.example.campushub.studentassignment.repository;

import static com.example.campushub.dept.domain.QDept.*;
import static com.example.campushub.user.domain.QUser.*;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.studentassignment.dto.QStudentAssignmentResponseDto;
import com.example.campushub.studentassignment.dto.StudentAssignSearchCondition;
import com.example.campushub.studentassignment.dto.StudentAssignmentResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentAssignmentRepositoryCustomImpl implements StudentAssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//과제제축학생 전체 조회
	// List<StudentAssignmentResponseDto> findByCondition(StudentAssignSearchCondition cond) {
	// 	return queryFactory.select(new QStudentAssignmentResponseDto(
	// 		user.userName,
	// 		user.userNum,
	// 		dept.deptName,
	//
	// 	))
	// }
}
