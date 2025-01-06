package com.example.campushub.attendance.domain;

import static jakarta.persistence.FetchType.*;

import com.example.campushub.nweek.domain.NWeek;
import com.example.campushub.usercourse.domain.UserCourse;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_course_id")
	private UserCourse userCourse;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "nweek_id")
	private NWeek nWeek;

	@Enumerated(EnumType.STRING)
	private AttendanceStatus status;
}
