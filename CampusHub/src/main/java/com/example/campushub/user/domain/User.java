package com.example.campushub.user.domain;

import com.example.campushub.dept.domain.Dept;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String userNum;
    private String password;
    private String userName;
    private String birthday;

    //학과 매핑
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    private String email;
    private String phone;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String refreshToken;

    @Builder
    public User(String userNum,String password, String userName, String birthday, String email, String phone, String address,
        Dept dept, Grade grade, Role role, Type type, Status status, String refreshToken) {
        this.userNum = userNum;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dept = dept;
        this.grade = grade;
        this.role = role;
        this.type = type;
        this.status = status;
        this.refreshToken = refreshToken;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void invalidateRefreshToken() {
        this.refreshToken = null;
    }

}