package com.example.campushub.scholarship.repository;

import com.example.campushub.scholarship.domain.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long>, ScholarshipRepositoryCustom {
}
