package com.example.campushub.studentassignment.dto;

import java.time.LocalDate;

import com.example.campushub.nweek.domain.Week;
import com.example.campushub.studentassignment.domain.SubmitStatus;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentAssignmentsResponse {
	private Week week;
	private String courseName;
	private String professorName;
	private SubmitStatus status;
	private LocalDate limitDate;
	private LocalDate createDate;

	@Builder
	@QueryProjection
	public StudentAssignmentsResponse(Week week, String courseName, String professorName, SubmitStatus status,
		LocalDate limitDate, LocalDate createDate) {
		this.week = week;
		this.courseName = courseName;
		this.professorName = professorName;
		this.status = status;
		this.limitDate = limitDate;
		this.createDate = createDate;
	}
}
