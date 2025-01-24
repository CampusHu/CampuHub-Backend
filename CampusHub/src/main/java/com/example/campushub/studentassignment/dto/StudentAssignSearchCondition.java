package com.example.campushub.studentassignment.dto;

import com.example.campushub.nweek.domain.Week;
import com.example.campushub.studentassignment.domain.SubmitStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentAssignSearchCondition {

	private String CourseName;
	private Week week;
	private SubmitStatus status;

	@Builder
	public StudentAssignSearchCondition(String courseName, Week week, SubmitStatus status) {
		CourseName = courseName;
		this.week = week;
		this.status = status;
	}
}
