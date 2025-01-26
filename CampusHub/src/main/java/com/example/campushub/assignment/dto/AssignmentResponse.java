package com.example.campushub.assignment.dto;

import java.time.LocalDate;

import com.example.campushub.nweek.domain.Week;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentResponse {
	private String courseName;
	private String professorName;
	private Week week;
	private LocalDate createDate;
	private String explain;
	private LocalDate limitDate;

	@Builder
	@QueryProjection
	public AssignmentResponse(String courseName, String professorName, Week week, LocalDate createDate, String explain,
		LocalDate limitDate) {
		this.courseName = courseName;
		this.professorName = professorName;
		this.week = week;
		this.createDate = createDate;
		this.explain = explain;
		this.limitDate = limitDate;
	}
}
