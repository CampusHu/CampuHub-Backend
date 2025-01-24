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
import com.example.campushub.course.domain.Course;
import com.example.campushub.course.domain.QCourse;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentRepositoryCustomImpl implements AssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//과제 전체 조회(학생)
	@Override
	public List<AssignmentFindAllResponse> findAllAssignment(String courseName) {
		return queryFactory.select(new QAssignmentFindAllResponse(
			nWeek.week,
			course.courseName,
			user.userName,
			assignment.limitDate,
			assignment.createDate
		))
			.from(assignment)
			.join(nWeek).on(assignment.nWeek.eq(nWeek))
			.join(course).on(nWeek.course.eq(course))
			.join(user).on(course.user.eq(user))
			.where(course.courseName.eq(courseName))
			.fetch();
	}

	//과제 컨디션 조회

}
