package com.example.campushub.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.course.domain.Course;
import com.example.campushub.course.dto.CourseCreateDto;
import com.example.campushub.course.dto.CourseResponseDto;
import com.example.campushub.course.dto.ProfCourseSearchCondition;
import com.example.campushub.course.repository.CourseRepository;
import com.example.campushub.global.error.exception.DuplicateCourseException;
import com.example.campushub.global.error.exception.UserNotFoundException;
import com.example.campushub.schoolyear.domain.SchoolYear;
import com.example.campushub.schoolyear.dto.SchoolYearResponseDto;
import com.example.campushub.schoolyear.repository.SchoolYearRepository;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import com.example.campushub.usercourse.domain.UserCourse;
import com.example.campushub.usercourse.repository.UserCourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

	private final CourseRepository courseRepository;
	private final UserRepository userRepository;
	private final SchoolYearRepository schoolYearRepository;
	private final UserCourseRepository userCourseRepository;

	//강의 생성
	@Transactional
	public void createCourse(LoginUser loginUser, CourseCreateDto createDto) {
		User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), loginUser.getType())
			.orElseThrow(UserNotFoundException::new);

		//강의 중복 조건
		if (courseRepository.isCourseOverlapping(createDto)){
			throw new DuplicateCourseException();
		}

		//학년도 학기 가져오기(학년도 엔티티중 iscurrent가 true인 엔티티 가져오기)
		SchoolYearResponseDto schoolYearDto = schoolYearRepository.getCurrentSchoolYear();

		SchoolYear schoolYear = SchoolYear.builder()
			.year(schoolYearDto.getYear())
			.semester(schoolYearDto.getSemester())
			.is_current(schoolYearDto.is_current())
			.build();

		Course course = Course.builder()
			.courseName(createDto.getCourseName())
			.room(createDto.getRoom())
			.division(createDto.getDivision())
			.courseDay(createDto.getCourseDay())
			.courseGrade(createDto.getCourseGrade())
			.user(user)
			.schoolYear(schoolYear)
			.startPeriod(createDto.getStartPeriod())
			.endPeriod(createDto.getEndPeriod())
			.creditScore(createDto.getCredits())
			.attScore(createDto.getAttScore())
			.assignScore(createDto.getAssignScore())
			.midExam(createDto.getMidScore())
			.finalExam(createDto.getFinalScore())
			.build();

		UserCourse userCourse = UserCourse.builder()
			.user(user)
			.course(course)
			.build();

		courseRepository.save(course);
		userCourseRepository.save(userCourse);
	}

	//전체+컨디션 강의 조회
	public List<CourseResponseDto> findAllByCondition(LoginUser loginUser, ProfCourseSearchCondition cond) {
		userRepository.findByUserNumAndType(loginUser.getUserNum(), loginUser.getType())
			.orElseThrow(UserNotFoundException::new);

		return courseRepository.findAllByCondition(cond);
	}



	//본인 강의 조회


}
