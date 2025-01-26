package com.example.campushub.studentassignment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.assignment.domain.Assignment;
import com.example.campushub.assignment.repository.AssignmentRepository;
import com.example.campushub.course.domain.Course;
import com.example.campushub.global.error.exception.AssignmentNotFoundException;
import com.example.campushub.global.error.exception.UserNotFoundException;
import com.example.campushub.studentassignment.domain.StudentAssignment;
import com.example.campushub.studentassignment.dto.StudentAssignCreateDto;
import com.example.campushub.studentassignment.repository.StudentAssignmentRepository;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import com.example.campushub.usercourse.domain.UserCourse;
import com.example.campushub.usercourse.repository.UserCourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentAssignmentService {

	private final StudentAssignmentRepository studentAssignmentRepository;
	private final UserRepository userRepository;
	private final AssignmentRepository assignmentRepository;
	private final UserCourseRepository userCourseRepository;

	@Transactional
	public void createStudentAssignment(LoginUser loginUser, StudentAssignCreateDto createDto, Long assignmentId) {
		User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), loginUser.getType())
			.orElseThrow(UserNotFoundException::new);

		Assignment assignment = assignmentRepository.findById(assignmentId)
			.orElseThrow(AssignmentNotFoundException::new);

		Course course = assignment.getNWeek().getCourse();

		UserCourse userCourse = userCourseRepository.findByCourseAndUser(course, user);

		//과제 생성할 때 학생 과제도 같이 생성 -> 이 때 학생 과제 생성후 학생이 과제 작석하고 제출시 학생 과제 edit

		//
		// StudentAssignment studentAssignment = StudentAssignment.builder()
		// 	.assignment(assignment)
		// 	.userCourse(userCourse)
		// 	.courseTitle(createDto.getTitle())
		// 	.courseContent(createDto.getContent())
		//

	}
}
