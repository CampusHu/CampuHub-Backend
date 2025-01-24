package com.example.campushub.studentassignment.repository;

import static com.example.campushub.assignment.domain.QAssignment.*;
import static com.example.campushub.course.domain.QCourse.*;
import static com.example.campushub.dept.domain.QDept.*;
import static com.example.campushub.nweek.domain.QNWeek.*;
import static com.example.campushub.studentassignment.domain.QStudentAssignment.*;
import static com.example.campushub.user.domain.QUser.*;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.studentassignment.domain.QStudentAssignment;
import com.example.campushub.studentassignment.dto.AssignmentSearchCondition;
import com.example.campushub.studentassignment.dto.QStudentAssignmentResponseDto;
import com.example.campushub.studentassignment.dto.QStudentAssignmentsResponse;
import com.example.campushub.studentassignment.dto.StudentAssignSearchCondition;
import com.example.campushub.studentassignment.dto.StudentAssignmentResponseDto;
import com.example.campushub.studentassignment.dto.StudentAssignmentsResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentAssignmentRepositoryCustomImpl implements StudentAssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//과제 전체 조회(학생)
	// public List<StudentAssignmentsResponse> findAllAssignmentByCondition(List<>) {
	// 	return queryFactory.select(new QStudentAssignmentsResponse(
	// 		nWeek.week,
	// 		course.courseName,
	// 		user.userName,
	// 		studentAssignment.status,
	// 		assignment.limitDate,
	// 		assignment.createDate
	// 	))
	// 		.from(studentAssignment)
	// 		.join()
	// }
	//과제 컨디션 조회(학생)

}
