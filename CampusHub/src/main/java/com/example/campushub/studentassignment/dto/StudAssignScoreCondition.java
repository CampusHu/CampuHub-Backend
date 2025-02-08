package com.example.campushub.studentassignment.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudAssignScoreCondition {
	private String courseName;
	private String userNum;

	@Builder
	public StudAssignScoreCondition(String courseName, String userNum) {
		this.courseName = courseName;
		this.userNum = userNum;
	}
}
