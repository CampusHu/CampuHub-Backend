package com.example.campushub.usercourse.domain;

import static jakarta.persistence.FetchType.*;

import com.example.campushub.course.domain.Course;
import com.example.campushub.user.domain.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCourse {

	@Id
	@Column(name = "user_course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
}
