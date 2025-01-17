package com.example.campushub.course.repository;

import static com.example.campushub.course.domain.QCourse.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.course.domain.Course;
import com.example.campushub.course.domain.CourseDay;
import com.example.campushub.course.domain.QCourse;
import com.example.campushub.course.dto.CourseCreateDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public boolean isCourseOverlapping(CourseCreateDto createDto) {
		return queryFactory
			.selectOne()
			.from(course)
			.where(
				isSameCourseCondition(createDto.getCourseName(), createDto.getDay(), createDto.getStartPeriod(), createDto.getEndPeriod())
					.or(isSameRoomCondition(createDto.getRoom(), createDto.getDay(), createDto.getStartPeriod(), createDto.getEndPeriod()))
			)
			.fetchFirst() != null; // 데이터가 존재하면 true 반환
	}

	// 시간 범위가 겹치는 조건
	private BooleanExpression isTimeOverlapping(int startPeriod, int endPeriod) {
		return course.startPeriod.loe(endPeriod) // 새로운 시작 교시 <= 기존 끝 교시
			.and(course.endPeriod.goe(startPeriod)); // 새로운 끝 교시 >= 기존 시작 교시
	}

	// 강의명, 요일, 시간 조건
	private BooleanExpression isSameCourseCondition(String name, CourseDay courseDay, int startPeriod, int endPeriod) {
		return course.courseName.eq(name)
			.and(course.courseDay.eq(courseDay))
			.and(isTimeOverlapping(startPeriod, endPeriod));
	}

	// 강의실, 요일, 시간 조건
	private BooleanExpression isSameRoomCondition(String room, CourseDay courseDay, int startPeriod, int endPeriod) {
		return course.room.eq(room)
			.and(course.courseDay.eq(courseDay))
			.and(isTimeOverlapping(startPeriod, endPeriod));
	}

}
