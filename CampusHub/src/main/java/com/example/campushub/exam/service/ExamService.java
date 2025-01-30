package com.example.campushub.exam.service;

import com.example.campushub.exam.domain.Exam;
import com.example.campushub.exam.dto.ExamEditDto;
import com.example.campushub.exam.dto.ExamFindAllResponse;
import com.example.campushub.exam.dto.ExamScoreInputRequest;
import com.example.campushub.exam.dto.ExamScoreUpdateResponse;
import com.example.campushub.exam.repository.ExamRepository;
import com.example.campushub.global.error.exception.UserNotFoundException;
import com.example.campushub.user.domain.Type;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.campushub.global.error.exception.ExamNotFoundException;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamService {

    private final UserRepository userRepository;
    private final ExamRepository examRepository;


    //교수 성적 조회
    public List<ExamFindAllResponse> getExamScores(LoginUser loginUser, Long userCourseId) {
        User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.STUDENT)
                .orElseThrow(UserNotFoundException::new);
        return examRepository.findExamScoresByUserCourseId(userCourseId);
    }


    //성적 기입
    @Transactional
    public ExamScoreUpdateResponse updateExamScore(LoginUser loginUser, ExamScoreInputRequest request) {
        validateUserType(loginUser);
        examRepository.updateExamScore(request);

        // 총점 계산 후 응답 DTO 생성
        return ExamScoreUpdateResponse.builder()
                .examId(request.getExamId())
                .midScore(request.getMidScore())
                .finalScore(request.getFinalScore())
                .totalScore(request.getMidScore() + request.getFinalScore()) // 총점 계산
                .build();
    }

    private void validateUserType(LoginUser loginUser) {
        if (!loginUser.getType().equals(Type.PROFESSOR)) {
            throw new SecurityException("권한이 없습니다.");
        }
    }

    // 점수 수정
    @Transactional
    public void editExam(Long examId, ExamEditDto editDto) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(ExamNotFoundException::new);

        // totalScore 계산
        int totalScore = editDto.getMidExamScore() + editDto.getFinalExamScore();

        // Exam 도메인의 edit 메서드 호출
        exam.edit(editDto.getMidExamScore(), editDto.getFinalExamScore(), totalScore);
    }


}
