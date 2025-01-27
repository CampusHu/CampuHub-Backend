package com.example.campushub.studentassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.campushub.assignment.domain.Assignment;
import com.example.campushub.studentassignment.domain.StudentAssignment;
import com.example.campushub.usercourse.domain.UserCourse;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Long> {

	StudentAssignment findByAssignmentAndUserCourse(Assignment assignment, UserCourse userCourse);
}
