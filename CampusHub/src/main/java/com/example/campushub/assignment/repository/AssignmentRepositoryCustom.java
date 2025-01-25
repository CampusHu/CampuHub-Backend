package com.example.campushub.assignment.repository;

import java.util.List;

import com.example.campushub.assignment.dto.AssignmentFindAllResponse;
import com.example.campushub.assignment.dto.AssignmentSearchCondition;

public interface AssignmentRepositoryCustom {

	List<AssignmentFindAllResponse> findAllAssigmentByCond(AssignmentSearchCondition condition, List<String> courseNames);
}
