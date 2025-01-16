package com.example.campushub.attendance.service;


import com.example.campushub.attendance.dto.AttendanceResponseDto;
import com.example.campushub.attendance.dto.AttendanceSearchCondition;
import com.example.campushub.attendance.repository.AttendanceRepository;
import com.example.campushub.global.error.exception.UserNotFoundException;
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
@Transactional
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public List<AttendanceResponseDto> findAttendance(AttendanceSearchCondition atten, LoginUser loginUser) {
            User professor = userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.PROFESSOR)
                    .orElseThrow(UserNotFoundException::new);

            return attendanceRepository.findAllByCondition(atten);
    }
}
