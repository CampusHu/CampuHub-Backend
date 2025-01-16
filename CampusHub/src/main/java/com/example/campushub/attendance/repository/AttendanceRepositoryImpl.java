package com.example.campushub.attendance.repository;

import com.example.campushub.attendance.domain.QAttendance;
import com.example.campushub.attendance.dto.AttendanceResponseDto;
import com.example.campushub.attendance.dto.AttendanceSearchCondition;
import com.example.campushub.attendance.dto.QAttendanceResponseDto;
import com.example.campushub.nweek.domain.Week;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.campushub.attendance.domain.QAttendance.attendance;
import static com.example.campushub.course.domain.QCourse.course;
import static com.example.campushub.nweek.domain.QNWeek.nWeek;
import static com.example.campushub.user.domain.QUser.user;
import static com.example.campushub.usercourse.domain.QUserCourse.userCourse;


@Repository
@RequiredArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AttendanceResponseDto> findAllByCondition(AttendanceSearchCondition atten) {
        return queryFactory.select(new QAttendanceResponseDto(
                user.userName,
                user.userNum,
                attendance.status
        )).from(attendance)
                .join(userCourse.user,user)
                .join(userCourse.course,course)
                .join(attendance.userCourse,userCourse)
                .join(attendance.nWeek,nWeek)
                .where(eqCourseName(atten.getCourseName()), eqNweek(atten.getWeek()))
                .fetch();
    }

    private BooleanExpression eqCourseName(String courseName) {
        return courseName == null ? null : course.courseName.eq(courseName);
    }

    private BooleanExpression eqNweek(Week week) {
        return week == null ? null : nWeek.week.eq(week);
    }
}
