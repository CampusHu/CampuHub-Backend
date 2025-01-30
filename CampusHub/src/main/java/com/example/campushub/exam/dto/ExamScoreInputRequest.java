package com.example.campushub.exam.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamScoreInputRequest {
    private Long examId;
    private int midScore;
    private int finalScore;


    @Builder
    @QueryProjection
    public ExamScoreInputRequest(Long examId, int midScore, int finalScore) {
        this.examId = examId;
        this.midScore = midScore;
        this.finalScore = finalScore;
    }
}
