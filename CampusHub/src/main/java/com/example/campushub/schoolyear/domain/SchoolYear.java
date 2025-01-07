package com.example.campushub.schoolyear.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date year;
    @Enumerated(EnumType.STRING)
    private Semester semester;
    private boolean is_current;

    @Builder
    public SchoolYear(Date year, Semester semester, boolean is_current) {
        this.year = year;
        this.semester = semester;
        this.is_current = is_current;
    }

}
