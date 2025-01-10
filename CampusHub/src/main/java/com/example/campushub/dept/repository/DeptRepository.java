package com.example.campushub.dept.repository;

import com.example.campushub.dept.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {
}
