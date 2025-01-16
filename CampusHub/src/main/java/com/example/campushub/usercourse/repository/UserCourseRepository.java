package com.example.campushub.usercourse.repository;

import com.example.campushub.usercourse.domain.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
}
