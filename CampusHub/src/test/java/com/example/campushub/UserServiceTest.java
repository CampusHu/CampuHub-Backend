// package com.example.campushub;
//
// import static org.assertj.core.api.Assertions.*;
//
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import com.example.campushub.user.dto.UserResponseDto;
// import com.example.campushub.user.repository.UserRepository;
// import com.example.campushub.user.service.UserService;
//
// @SpringBootTest
// public class UserServiceTest {
//
// 	@Autowired
// 	private UserService userService;
//
// 	@Autowired
// 	private UserRepository userRepository;
//
// 	@AfterEach
// 	public void tearDown() {
// 		userRepository.deleteAllInBatch();
// 	}
//
// 	@Test
// 	public void test() {
// 		// given`
// 		User user = userRepository.save(new User());
//
// 		// when
// 		Response response = userService.getBreakPendingUser(user);
//
// 		// then
// 		assertThat(response.getId()).isEqualTo(1L);
// 	}
//
// }
