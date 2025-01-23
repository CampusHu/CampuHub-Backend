package com.example.campushub.assignment.dto;

import com.example.campushub.nweek.domain.Week;

import lombok.Builder;

public class AssignmentSearchCondition {

	private String courseName;
	private Week week;

	@Builder
	public AssignmentSearchCondition(String courseName, Week week) {
		this.courseName = courseName;
		this.week = week;
	}
}
