package com.example.campushub.assignment.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.assignment.domain.Assignment;
import com.example.campushub.assignment.dto.AssignmentCreateRequest;
import com.example.campushub.assignment.dto.AssignmentFindAllResponse;
import com.example.campushub.assignment.dto.AssignmentSearchCondition;
import com.example.campushub.assignment.repository.AssignmentRepository;
import com.example.campushub.course.domain.Course;
import com.example.campushub.course.repository.CourseRepository;
import com.example.campushub.global.error.exception.CourseNotFoundException;
import com.example.campushub.global.error.exception.UserNotFoundException;
import com.example.campushub.nweek.domain.NWeek;
import com.example.campushub.nweek.repository.NweekRepository;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentService {

	private final AssignmentRepository assignmentRepository;
	private final NweekRepository nweekRepository;
	private final CourseRepository courseRepository;
	private final UserRepository userRepository;

	//과제 등록
	@Transactional
	public void createAssignment(LoginUser loginUser, AssignmentCreateRequest request) {
		User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), loginUser.getType())
			.orElseThrow(UserNotFoundException::new);

		Course course = courseRepository.findByCourseNameAndUser(request.getCourseName(), user)
			.orElseThrow(CourseNotFoundException::new);

		NWeek nweek = nweekRepository.findByCourseAndWeek(course, request.getWeek());

		Assignment assignment = Assignment.builder()
			.nWeek(nweek)
			.explain(request.getExplain())
			.createDate(LocalDate.now())
			.limitDate(request.getLimitDate())
			.build();

		assignmentRepository.save(assignment);
	}

	//과제 전체 조회(학생)
	public List<AssignmentFindAllResponse> findAllByCondition(LoginUser loginUser, AssignmentSearchCondition cond) {
		User user = userRepository.findByUserNumAndType(loginUser.getUserNum(), loginUser.getType())
			.orElseThrow(UserNotFoundException::new);

		return null;
	}
}
