package com.example.campushub.scholarship.controller;

import com.example.campushub.global.security.Login;
import com.example.campushub.scholarship.dto.ScholarshipResponseDto;
import com.example.campushub.scholarship.dto.ScholarshipSearchCondition;
import com.example.campushub.scholarship.service.ScholarshipService;
import com.example.campushub.user.dto.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ScholarshipController {

    private final ScholarshipService scholarshipService;

    public String findScholarships(ScholarshipSearchCondition cond, @Login LoginUser loginUser, Model model) {
        List<ScholarshipResponseDto> response = scholarshipService.findScholarships(cond, loginUser);
        model.addAttribute("scholarships", response);

        return "shcloarships";
    }

}
