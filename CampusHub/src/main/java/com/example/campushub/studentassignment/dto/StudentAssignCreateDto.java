package com.example.campushub.studentassignment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentAssignCreateDto {
	private String title;
	private String content;

	@Builder
	public StudentAssignCreateDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
