package com.example.campushub.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.campushub.assignment.domain.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>, AssignmentRepositoryCustom {
}
