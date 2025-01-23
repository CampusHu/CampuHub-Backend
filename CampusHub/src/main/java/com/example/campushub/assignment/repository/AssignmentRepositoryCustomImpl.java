package com.example.campushub.assignment.repository;

import static com.example.campushub.assignment.domain.QAssignment.*;
import static com.example.campushub.course.domain.QCourse.*;
import static com.example.campushub.nweek.domain.QNWeek.*;
import static com.example.campushub.user.domain.QUser.*;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.assignment.dto.AssignmentFindAllResponse;
import com.example.campushub.assignment.dto.AssignmentSearchCondition;
import com.example.campushub.assignment.dto.QAssignmentFindAllResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentRepositoryCustomImpl implements AssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;
	//
	// //과제 목록 조회
	// public List<AssignmentFindAllResponse> findAllAssignByCondition(AssignmentSearchCondition cond) {
	// 	return queryFactory.select(new QAssignmentFindAllResponse(
	// 		nWeek.week,
	// 		course.courseName,
	// 		user.userName,
	// 		assignment.limitDate,
	// 		assignment.createDate
	// 	))
	// 		.from(assignment)
	// 		.join
	// }
	//

}
