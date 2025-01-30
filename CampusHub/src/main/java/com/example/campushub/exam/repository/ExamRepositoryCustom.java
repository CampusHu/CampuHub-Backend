package com.example.campushub.exam.repository;

import com.example.campushub.exam.dto.ExamFindAllResponse;
import com.example.campushub.exam.dto.ExamScoreInputRequest;

import java.util.List;

public interface ExamRepositoryCustom {

    List<ExamFindAllResponse> findExamScoresByUserCourseId(Long userCourseId);

    void updateExamScore(ExamScoreInputRequest request);
}
