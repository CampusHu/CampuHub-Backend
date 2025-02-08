package com.example.campushub.studentassignment.repository;



import static com.example.campushub.assignment.domain.QAssignment.*;
import static com.example.campushub.course.domain.QCourse.*;
import static com.example.campushub.dept.domain.QDept.*;
import static com.example.campushub.nweek.domain.QNWeek.*;
import static com.example.campushub.studentassignment.domain.QStudentAssignment.*;
import static com.example.campushub.user.domain.QUser.*;
import static com.example.campushub.usercourse.domain.QUserCourse.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.assignment.dto.QAssignmentResponse;
import com.example.campushub.nweek.domain.Week;
import com.example.campushub.studentassignment.domain.QStudentAssignment;
import com.example.campushub.studentassignment.domain.StudentAssignment;
import com.example.campushub.studentassignment.domain.SubmitStatus;
import com.example.campushub.studentassignment.dto.QStudAssignScoresResponse;
import com.example.campushub.studentassignment.dto.QStudentAssignFindOneDto;
import com.example.campushub.studentassignment.dto.QStudentAssignmentResponse;
import com.example.campushub.studentassignment.dto.StudAssignScoreCondition;
import com.example.campushub.studentassignment.dto.StudAssignScoresResponse;
import com.example.campushub.studentassignment.dto.StudentAssigmentSearchCondition;
import com.example.campushub.studentassignment.dto.StudentAssignFindOneDto;
import com.example.campushub.studentassignment.dto.StudentAssignmentResponse;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentAssignmentRepositoryCustomImpl implements StudentAssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	//학생 과제 전체 조회
	@Override
	public List<StudentAssignmentResponse> getAllStudentAssignments(StudentAssigmentSearchCondition cond) {
		return queryFactory.select(new QStudentAssignmentResponse(
			studentAssignment.id,
			user.userName,
			user.userNum,
			dept.deptName,
			studentAssignment.submitDate,
			studentAssignment.assignmentScore,
			studentAssignment.status
		))
			.from(course)
			.join(nWeek).on(nWeek.course.eq(course))
			.join(assignment).on(assignment.nWeek.eq(nWeek))
			.join(studentAssignment).on(studentAssignment.assignment.eq(assignment))
			.join(userCourse).on(studentAssignment.userCourse.eq(userCourse))
			.join(user).on(userCourse.user.eq(user))
			.join(dept).on(user.dept.eq(dept))
			.where(course.courseName.eq(cond.getCourseName()),
				(nWeek.week.eq(Week.of(cond.getWeek()))),
				submitStatusEq(cond.getStatus()))
			.fetch();

	}

	// 학생 과제 단건 조회
	@Override
	public Optional<StudentAssignFindOneDto> getStudentAssignment(Long StudentAssignmentId) {
		StudentAssignFindOneDto fetchOne = queryFactory.select(new QStudentAssignFindOneDto(
			course.courseName,
			nWeek.week,
			user.userName,
			user.userNum,
			dept.deptName,
			studentAssignment.status,
			studentAssignment.assignmentTitle,
			studentAssignment.assignmentContent
		))
			.from(studentAssignment)
			.join(assignment).on(studentAssignment.assignment.eq(assignment))
			.join(nWeek).on(assignment.nWeek.eq(nWeek))
			.join(course).on(nWeek.course.eq(course))
			.join(userCourse).on(studentAssignment.userCourse.eq(userCourse))
			.join(user).on(userCourse.user.eq(user))
			.join(dept).on(user.dept.eq(dept))
			.where(studentAssignment.id.eq(StudentAssignmentId))
			.fetchOne();

		return Optional.ofNullable(fetchOne);
	}

	public List<StudAssignScoresResponse> findStudAssignScoresByCond(StudAssignScoreCondition cond) {
		return queryFactory.select(new QStudAssignScoresResponse(
			user.userName,
			user.userNum,
			getWeekScore(Week.FIRST),
			getWeekScore(Week.SECOND),
			getWeekScore(Week.THIRD),
			getWeekScore(Week.FOURTH),
			getWeekScore(Week.FIFTH),
			getWeekScore(Week.SIXTH),
			getWeekScore(Week.SEVENTH),
			getWeekScore(Week.EIGHTH),
			getWeekScore(Week.NINTH),
			getWeekScore(Week.TENTH),
			getWeekScore(Week.ELEVENTH),
			getWeekScore(Week.TWELFTH),
			getWeekScore(Week.THIRTEENTH),
			getWeekScore(Week.FOURTEENTH),
			getWeekScore(Week.FIFTEENTH),
			getWeekScore(Week.SIXTEENTH)
		))
			.from(studentAssignment)
			.leftJoin(studentAssignment.userCourse, userCourse)
			.join(studentAssignment.assignment, assignment)
			.join(assignment.nWeek, nWeek)
			.join(userCourse.course, course)
			.join(userCourse.user, user)
			.where(course.courseName.eq(cond.getCourseName()),
				userNumEq(cond.getUserNum()))
			.fetch();
	}
	private BooleanExpression userNumEq(String userNum) {
		return userNum == null ? null : user.userNum.eq(userNum);
	}

	private BooleanExpression submitStatusEq(String status) {
		return status == null ? null : studentAssignment.status.eq(SubmitStatus.of(status));
	}
	private Expression<Integer> getWeekScore(Week week) {
		return new CaseBuilder()
			.when(nWeek.week.eq(week)).then(studentAssignment.assignmentScore)
			.otherwise(0);
	}

}
