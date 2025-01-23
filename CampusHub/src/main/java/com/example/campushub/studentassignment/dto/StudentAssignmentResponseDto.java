package com.example.campushub.studentassignment.dto;

import java.time.LocalDateTime;

import com.example.campushub.studentassignment.domain.SubmitStatus;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentAssignmentResponseDto {
	private String userName;
	private String userNum;
	private String deptName;
	private LocalDateTime submitDate;
	private int assignmentGrade;
	private SubmitStatus status;

	@Builder
	@QueryProjection
	public StudentAssignmentResponseDto(String userName, String userNum, String deptName, LocalDateTime submitDate,
		int assignmentGrade, SubmitStatus status) {
		this.userName = userName;
		this.userNum = userNum;
		this.deptName = deptName;
		this.submitDate = submitDate;
		this.assignmentGrade = assignmentGrade;
		this.status = status;
	}
}
