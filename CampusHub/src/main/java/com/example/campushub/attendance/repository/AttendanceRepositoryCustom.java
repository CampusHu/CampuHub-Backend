package com.example.campushub.attendance.repository;

import com.example.campushub.attendance.dto.AttendanceResponseDto;
import com.example.campushub.attendance.dto.AttendanceSearchCondition;

import java.util.List;

public interface AttendanceRepositoryCustom {

    List<AttendanceResponseDto> findAllByCondition(AttendanceSearchCondition atten);
}
