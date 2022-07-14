package com.example.logintest.Web.dto;

// Lombok = Getter, Setter 자동화
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    // JPA
    private String email;
    private String password;
    private String auth;
}

