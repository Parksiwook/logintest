package com.example.logintest.Web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private String email;
    private String password;
    private String auth;
}

// 이메일과 비밀번호 권한정보를 dto에 담음