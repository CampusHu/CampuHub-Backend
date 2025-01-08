package com.example.campushub.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.campushub.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByRefreshToken(String refreshToken);

	Optional<User> findByUserNum(String userNum);

	boolean existsByUserNum(String userNum);

}
