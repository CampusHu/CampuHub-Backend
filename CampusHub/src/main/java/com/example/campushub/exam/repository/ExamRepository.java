package com.example.campushub.exam.repository;

import com.example.campushub.exam.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long>, ExamRepositoryCustom {
    List<Exam> findByUserCourseId(Long userCourseId);
}
