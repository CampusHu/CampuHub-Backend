package com.example.campushub.departmentnotice.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepartmentNoticeSearchCondition {

    private String filter;  // "title" 또는 "createdBy"
    private String keyword; // 검색어

    @Builder
    @QueryProjection
    public DepartmentNoticeSearchCondition(String filter, String keyword) {
        this.filter = filter;
        this.keyword = keyword;
    }
}
