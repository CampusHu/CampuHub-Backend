package com.example.campushub.user.service;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.example.campushub.dept.domain.Dept;
import com.example.campushub.dept.repository.DeptRepository;
import com.example.campushub.global.config.QueryDslConfig;
import com.example.campushub.user.domain.Grade;
import com.example.campushub.user.domain.Role;
import com.example.campushub.user.domain.Status;
import com.example.campushub.user.domain.Type;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.dto.UserFindOneDto;
import com.example.campushub.user.repository.UserRepository;

@DataJpaTest
@Import({QueryDslConfig.class,UserService.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DeptRepository deptRepository;

	@AfterEach
	public void tearDown(){
		userRepository.deleteAllInBatch();
	}

	@Test
	@DisplayName("학생 단건조회")
	public void getStudentByUserNum() {
		//given
		Dept dept = deptRepository.save(createDept("건축과"));
		User student= userRepository.save(createUser("12343", dept));

		User admin = userRepository.save((createAdmin("0001")));


		LoginUser loginUser = createLoginUser(admin);

		//then
		UserFindOneDto result = userService.getStudentByUserNum(loginUser, student.getUserNum());

		//when
		assertThat(result).isNotNull();
		assertThat(result.getUserNum()).isEqualTo(student.getUserNum());
		assertThat(result.getUserName()).isEqualTo(student.getUserName());
		assertThat(result.getDeptName()).isEqualTo(dept.getDeptName());
	}

	private LoginUser createLoginUser(User user) {
		return LoginUser.builder()
			.userNum(user.getUserNum())
			.role(user.getRole())
			.type(user.getType())
			.build();
	}

	private Dept createDept(String deptName) {
		return Dept.builder()
			.deptName(deptName)
			.build();
	}

	private User createUser(String userNum, Dept dept) {
		return User.builder()
			.userName("김동릭")
			.userNum(userNum)
			.password("1234")
			.birthday(LocalDateTime.now())
			.email("aaa@gmail.com")
			.dept(dept)
			.phone("010-1234-5678")
			.address("경기도 성남시 분당구")
			.role(Role.USER)
			.type(Type.STUDENT)
			.grade(Grade.FIRST_GRADE)
			.status(Status.ENROLLED)
			.build();
	}

	private User createAdmin(String userNum) {
		return User.builder()
			.userName("김관리")
			.userNum(userNum)
			.password("1234")
			.email("aaa@gmail.com")
			.phone("010-1234-5678")
			.role(Role.ADMIN)
			.type(Type.ADMIN)
			.build();
	}


}
