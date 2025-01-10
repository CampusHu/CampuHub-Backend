package com.example.campushub.scholarship.repository;

import com.example.campushub.scholarship.dto.ScholarshipResponseDto;
import com.example.campushub.scholarship.dto.ScholarshipSearchCondition;

import java.util.List;

public interface ScholarshipRepositoryCustom {

    List<ScholarshipResponseDto> findAllByCondition(ScholarshipSearchCondition cond);
}
