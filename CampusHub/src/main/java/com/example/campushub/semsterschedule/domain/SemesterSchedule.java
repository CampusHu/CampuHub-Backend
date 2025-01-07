package com.example.campushub.semsterschedule.domain;

import static jakarta.persistence.FetchType.*;

import java.util.Date;

import com.example.campushub.schoolyear.domain.SchoolYear;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SemesterSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//학년도 매핑
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "schoolYear_id")
	private SchoolYear schoolYear;

	@Enumerated(EnumType.STRING)
	private Schedule schedule;
	private Date startDate;
	private Date endDate;
	private boolean dateCheck;
	private String eventName;

	@Builder
	public SemesterSchedule(SchoolYear schoolYear, Schedule schedule, Date startDate, Date endDate, boolean dateCheck, String eventName) {
		this.schoolYear = schoolYear;
		this.schedule = schedule;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dateCheck = dateCheck;
		this.eventName = eventName;
	}
}
