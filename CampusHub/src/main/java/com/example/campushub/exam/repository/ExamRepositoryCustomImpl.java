package com.example.campushub.exam.repository;


import com.example.campushub.exam.dto.ExamFindAllResponse;
import com.example.campushub.exam.dto.ExamScoreInputRequest;
import com.example.campushub.exam.dto.QExamFindAllResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.campushub.dept.domain.QDept.dept;
import static com.example.campushub.exam.domain.QExam.exam;
import static com.example.campushub.user.domain.QUser.user;
import static com.example.campushub.usercourse.domain.QUserCourse.userCourse;

@Repository
@RequiredArgsConstructor
public class ExamRepositoryCustomImpl implements ExamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ExamFindAllResponse> findExamScoresByUserCourseId(Long userCourseId) {

        return queryFactory.select(new QExamFindAllResponse(
                        user.userName,
                        user.userNum,
                        dept.deptName,
                        exam.userCourse.id,
                        exam.midScore,
                        exam.finalScore,
                        exam.totalScore
                )).from(exam)
                .join(user).on(exam.userCourse.id.eq(userCourse.id)) // exam
                .join(dept).on(user.dept.eq(dept)) // user dept
                .where(eqUserCourseId(userCourseId))
                .fetch();
    }
    @Override
    @Transactional
    public void updateExamScore(ExamScoreInputRequest request) {
        queryFactory.update(exam)
                .set(exam.midScore, request.getMidScore())
                .set(exam.finalScore, request.getFinalScore())
                .set(exam.totalScore, request.getMidScore() + request.getFinalScore())
                .where(exam.id.eq(request.getExamId()))
                .execute();

    }
    private BooleanExpression eqUserCourseId(Long userCourseId) {
        return userCourseId != null ? exam.userCourse.id.eq(userCourseId) : null;
    }
}