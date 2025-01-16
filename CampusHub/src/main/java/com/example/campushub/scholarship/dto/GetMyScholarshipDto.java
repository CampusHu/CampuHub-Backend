package com.example.campushub.scholarship.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GetMyScholarshipDto {

    @DateTimeFormat(pattern = "yyyy")
    private LocalDate year;
    private Enum semester;
    private String scholarshipName;
    private Enum type;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate confDate;

    @Builder
    @QueryProjection
    public GetMyScholarshipDto(LocalDate year, Enum semester, String scholarshipName, Enum type, int amount, LocalDate confDate) {
        this.year = year;
        this.semester = semester;
        this.scholarshipName = scholarshipName;
        this.type = type;
        this.amount = amount;
        this.confDate = confDate;
    }

}
