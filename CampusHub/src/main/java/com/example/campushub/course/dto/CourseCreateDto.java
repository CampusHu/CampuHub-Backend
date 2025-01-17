package com.example.campushub.course.dto;

import com.example.campushub.course.domain.CourseDay;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseCreateDto {
	@NotBlank
	private String courseName;
	@NotBlank
	private String room;
	@NotBlank
	private String division;
	@NotBlank
	private CourseDay day;
	@NotBlank(message = "시작 시간을 입력해주세요")
	private int startPeriod;
	@NotBlank(message = "종료시간을 입력해주세요")
	private int endPeriod;
	@NotBlank(message = "학점을 입력해주세요")
	private int credits;
	@NotBlank(message = "출석 기준 점수를 입력해주세요")
	private int attScore;
	@NotBlank(message = "과제 기준 점수를 입력해주세요")
	private int assignScore;
	@NotBlank(message = "중간 기준 점수를 입력해주세요")
	private int midScore;
	@NotBlank(message = "기말 기준 점수를 입력해주세요")
	private int finalScore;

	@Builder
	public CourseCreateDto(String courseName, String room, String division, CourseDay day, int startPeriod, int endPeriod,
		int credits, int attScore, int assignScore, int midScore, int finalScore) {
		this.courseName = courseName;
		this.room = room;
		this.division = division;
		this.day = day;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.credits = credits;
		this.attScore = attScore;
		this.assignScore = assignScore;
		this.midScore = midScore;
		this.finalScore = finalScore;
	}
}
