package com.example.campushub.global.error.exception;

public class AttendanceNotFoundException extends ApiException {

	private static final String MESSAGE = "해당 출석에 대한 정보를 찾을 수 없습니다";

	public AttendanceNotFoundException() {
		super(MESSAGE);
	}

	public AttendanceNotFoundException(String fieldName, String message) {
		super(MESSAGE);
		addValidation(fieldName, message);
	}

	@Override
	public int getStatusCode() {
		return 404;
	}
}
