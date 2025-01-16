package com.example.campushub.scholarship.controller;

import com.example.campushub.global.security.Login;
import com.example.campushub.scholarship.dto.GetMyScholarshipDto;
import com.example.campushub.scholarship.dto.ScholarshipCreateDto;
import com.example.campushub.scholarship.dto.ScholarshipResponseDto;
import com.example.campushub.scholarship.dto.ScholarshipSearchCondition;
import com.example.campushub.scholarship.service.ScholarshipService;
import com.example.campushub.schoolyear.domain.Semester;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.dto.UserFindOneSimpleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ScholarshipController {

    private final ScholarshipService scholarshipService;

    public String findScholarships(ScholarshipSearchCondition cond, @Login LoginUser loginUser, Model model) {
        List<ScholarshipResponseDto> response = scholarshipService.findScholarships(cond, loginUser);
        model.addAttribute("scholarships", response);

        return "scholarship";
    }


    // 장학금 등록을 위한 POST 메서드
//    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)  // 요청이 성공적으로 처리되면 201 CREATED 상태 코드 반환
    public String createScholarship(@RequestBody @Valid ScholarshipCreateDto scholarshipCreateDto,
                                    @Login LoginUser loginUser,
                                    @RequestParam String userNum) {

        UserFindOneSimpleDto userInfo = scholarshipService.getUserSimpleInfo(userNum);



        // 장학금 등록 서비스 호출
        scholarshipService.createScholarship(scholarshipCreateDto, loginUser, userInfo);
        System.out.println("장학금 등록 완료");

        return "scholarship";  // 장학금 등록 완료 메시지
    }

    //장학 삭제 없앨 예정
//
//    public String deleteScholarship(@RequestParam String userNum,@Login LoginUser loginUser) {
//
//        scholarshipService.deleteScholarship(userNum,loginUser);
//        System.out.println("장학금 삭제 완료 ");
//
//        return "redirect:/scholarships";
//
//    }

    //로그인한 사용자 장학금 조회
//    @GetMapping("")
        public String findMyScholarships(@Login LoginUser loginUser, Model model) {
            List<GetMyScholarshipDto> scholarships = scholarshipService.findMyScholarships(loginUser);
            model.addAttribute("scholarships", scholarships);

            return null;
        }

}
