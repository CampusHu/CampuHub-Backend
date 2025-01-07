package com.example.campushub.semsterschedule.domain;

import static jakarta.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.campushub.schoolyear.domain.SchoolYear;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SemesterSchedule {

	@Id
	@Column(name = "semester_schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//학년도 매핑
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "school_year_id")
	private SchoolYear schoolYear;

	@Enumerated(EnumType.STRING)
	private Schedule schedule;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private boolean dateCheck;
	private String eventName;
}
