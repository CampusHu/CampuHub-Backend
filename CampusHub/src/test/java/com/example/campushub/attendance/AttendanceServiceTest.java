//package com.example.campushub.attendance;
//
//
//import com.example.campushub.attendance.domain.Attendance;
//import com.example.campushub.attendance.repository.AttendanceRepository;
//import com.example.campushub.course.domain.Course;
//import com.example.campushub.global.config.QueryDslConfig;
//import com.example.campushub.nweek.domain.NWeek;
//import com.example.campushub.user.domain.*;
//import com.example.campushub.user.dto.LoginUser;
//import com.example.campushub.user.repository.UserRepository;
//import com.example.campushub.usercourse.domain.UserCourse;
//import com.example.campushub.usercourse.repository.UserCourseRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//
//@DataJpaTest
//@Import({QueryDslConfig.class, AttendanceServiceTest.class})
//public class AttendanceServiceTest {
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserCourseRepository userCourseRepository;
//    @Autowired
//    private
//
//
//    @AfterEach
//    public void tearDown(){
//        attendanceRepository.deleteAllInBatch();
//    }
//
//    @Test
//    @DisplayName("출석 입력 전 학생 조회")
//    public void findByCond() {
//
//        //given
//        User professor = userRepository.save(createProfessor("12412"));
//        LoginUser loginUser = createLoginUser(professor);
//
//        User userA = userRepository.save(createUser("학생1","1906078"));
//        User userB = userRepository.save(createUser("학생2","1906088"));
//
//        Course courseA =
//
//        UserCourse userCourse = userCourseRepository.save()
//
//
//
//        //when
//
//
//        //then
//    }
//
//
//    private LoginUser createLoginUser(User user) {
//        return LoginUser.builder()
//                .userNum(user.getUserNum())
//                .role(user.getRole())
//                .type(user.getType())
//                .build();
//    }
//
//    private User createProfessor(String userNum) {
//        return User.builder()
//                .userName("전영욱")
//                .userNum(userNum)
//                .password("1234")
//                .email("test@aaa.com")
//                .phone("1029301923801")
//                .role(Role.USER)
//                .type(Type.PROFESSOR)
//                .grade(Grade.FIRST_GRADE)
//                .status(Status.BREAK)
//                .build();
//    }
//
//    private User createUser(String userName,String userNum) {
//        return User.builder()
//                .userName(userName)
//                .userNum(userNum)
//                .password("1234")
//                .email("test@aaa.com")
//                .phone("1029301923801")
//                .role(Role.USER)
//                .type(Type.PROFESSOR)
//                .grade(Grade.FIRST_GRADE)
//                .status(Status.BREAK)
//                .build();
//    }
//
//    private Course createCourse(String courseName){
//        return Course.builder()
//                .courseName(courseName)
//                .build();
//
//    }
//    private UserCourse createUserCourse(User user, Course course){
//        return UserCourse.builder()
//                .user(user)
//                .course(course)
//                .build();
//
//    }
//
//    private Attendance createAttendance(NWeek nWeek ,UserCourse userCourse){
//        return Attendance.builder()
//                .userCourse(userCourse)
//                .nWeek(nWeek)
//                .build();
//    }
//
//
//}
