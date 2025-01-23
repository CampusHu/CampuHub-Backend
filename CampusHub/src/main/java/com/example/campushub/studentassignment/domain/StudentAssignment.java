package com.example.campushub.studentassignment.domain;

import java.time.LocalDateTime;

import com.example.campushub.assignment.domain.Assignment;
import com.example.campushub.usercourse.domain.UserCourse;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentAssignment {

	@Id
	@Column(name = "student_assignment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignment_id")
	private Assignment assignment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_course_id")
	private UserCourse userCourse;

	private String courseTitle;
	private String courseContent;
	private LocalDateTime submitDate;
	private SubmitStatus status;
	private int courseGrade;
	//첨부파일

	@Builder

	public StudentAssignment(Assignment assignment, UserCourse userCourse, String courseTitle, String courseContent,
		LocalDateTime submitDate, SubmitStatus status, int courseGrade) {
		this.assignment = assignment;
		this.userCourse = userCourse;
		this.courseTitle = courseTitle;
		this.courseContent = courseContent;
		this.submitDate = submitDate;
		this.status = status;
		this.courseGrade = courseGrade;
	}
}
