package com.example.campushub.studentassignment.dto;

import com.example.campushub.nweek.domain.Week;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentAssigmentSearchCondition {

	private String courseName;
	private Week week;

	@Builder
	public StudentAssigmentSearchCondition(String courseName, Week week) {
		this.courseName = courseName;
		this.week = week;
	}
}
