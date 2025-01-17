package com.example.campushub.course.repository;

import com.example.campushub.course.dto.CourseCreateDto;

public interface CourseRepositoryCustom {

	boolean isCourseOverlapping(CourseCreateDto createDto);


}
