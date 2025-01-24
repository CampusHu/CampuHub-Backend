package com.example.campushub.assignment.repository;

import java.util.List;

import com.example.campushub.assignment.dto.AssignmentFindAllResponse;

public interface AssignmentRepositoryCustom {
	List<AssignmentFindAllResponse> findAllAssignment(String courseName);

}
