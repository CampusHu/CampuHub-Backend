package com.example.campushub.course.repository;

import java.util.List;

import com.example.campushub.course.dto.CourseCreateDto;
import com.example.campushub.course.dto.CourseResponseDto;
import com.example.campushub.course.dto.ProfCourseSearchCondition;

public interface CourseRepositoryCustom {

	boolean isCourseOverlapping(CourseCreateDto createDto);

	List<CourseResponseDto>findAllByCondition(ProfCourseSearchCondition condition);


}
