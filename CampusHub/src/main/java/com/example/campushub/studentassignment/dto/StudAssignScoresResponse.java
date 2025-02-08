package com.example.campushub.studentassignment.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudAssignScoresResponse {
	private String userName;
	private String userNum;
	private int score1;
	private int score2;
	private int score3;
	private int score4;
	private int score5;
	private int score6;
	private int score7;
	private int score8;
	private int score9;
	private int score10;
	private int score11;
	private int score12;
	private int score13;
	private int score14;
	private int score15;
	private int score16;

	@Builder
	@QueryProjection
	public StudAssignScoresResponse(String userName, String userNum, int score1, int score2, int score3, int score4,
		int score5, int score6, int score7, int score8, int score9, int score10, int score11, int score12, int score13,
		int score14, int score15, int score16) {
		this.userName = userName;
		this.userNum = userNum;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.score6 = score6;
		this.score7 = score7;
		this.score8 = score8;
		this.score9 = score9;
		this.score10 = score10;
		this.score11 = score11;
		this.score12 = score12;
		this.score13 = score13;
		this.score14 = score14;
		this.score15 = score15;
		this.score16 = score16;
	}
}
