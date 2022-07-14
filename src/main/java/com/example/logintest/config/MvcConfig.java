package com.example.logintest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// url 매핑하기
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("user");            // 메인 페이지 (로그인 성공)
        registry.addViewController("/signup").setViewName("signup");    // 회원가입 페이지
        registry.addViewController("/login").setViewName("login");      // 로그인 페이지
        registry.addViewController("/admin").setViewName("admin");      // 관리자 페이지 (admin)
    }
}