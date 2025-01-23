package com.example.campushub.studentassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.campushub.studentassignment.domain.StudentAssignment;


public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Long> {

}
