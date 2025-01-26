package com.example.campushub.studentassignment.repository;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentAssignmentRepositoryCustomImpl implements StudentAssignmentRepositoryCustom {

	private final JPAQueryFactory queryFactory;



}
