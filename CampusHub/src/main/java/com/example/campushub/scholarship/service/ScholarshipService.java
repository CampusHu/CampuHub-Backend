package com.example.campushub.scholarship.service;


import com.example.campushub.scholarship.dto.ScholarshipResponseDto;
import com.example.campushub.scholarship.dto.ScholarshipSearchCondition;
import com.example.campushub.scholarship.repository.ScholarshipRepository;
import com.example.campushub.user.domain.Type;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScholarshipService {

    private final UserRepository userRepository;
    private final ScholarshipRepository scholarshipRepository;
    public List<ScholarshipResponseDto> findScholarships(ScholarshipSearchCondition cond, LoginUser loginUser) {
        // 1. 요청한 사용자가 ADMIN인지 확인
        User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 없습니다."));

        // 2. 조회
        return scholarshipRepository.findAllByCondition(cond);
    }


}
