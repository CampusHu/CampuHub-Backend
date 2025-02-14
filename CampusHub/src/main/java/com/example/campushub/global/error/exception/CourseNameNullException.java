package com.example.campushub.global.error.exception;

public class CourseNameNullException extends ApiException {

	private static final String MESSAGE = "강의 명은 필수 입력 값입니다.";

	public CourseNameNullException() {
		super(MESSAGE);
	}

	public CourseNameNullException(String fieldName, String message) {
		super(MESSAGE);
		addValidation(fieldName, message);
	}

	@Override
	public int getStatusCode() {
		return 400;
	}
}
