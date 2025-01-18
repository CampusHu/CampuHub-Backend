package com.example.campushub.usercourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.campushub.user.domain.User;
import com.example.campushub.usercourse.domain.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
	UserCourse findBYUser(User user);
}
