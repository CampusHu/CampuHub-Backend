package com.example.campushub.userscholarship.repository;

import com.example.campushub.userscholarship.domain.UserScholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScholarshipRepository extends JpaRepository<UserScholarship, Integer> {
}
