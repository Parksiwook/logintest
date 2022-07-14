package com.example.logintest.config;


import com.example.logintest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security를 활성화하는 어노테이션
@Configuration // Bean 관리하는 어노테이션
// 해당 클래스가 Spring Security 설정 파일로 역할을 하기 위해선 WebSecurityConfigurerAdapter 클래스를 상속해야 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService; // 유저 정보를 가져올 클래스

    @Override
    // http 관련 인증 설정 가능
    public void configure(HttpSecurity http) throws Exception { //httpsecurity를 통해 먼저받아 URL별 인증여부 처리
        http
                    .authorizeRequests()//
                        .antMatchers("/login", "/signup", "/user").permitAll() // 누구나 접근 가능
                        .antMatchers("/").hasRole("USER") // USER, ADMIN 만 접근 가능
                        .anyRequest().authenticated() // 나머지는 권한이 있기만 하면 접근 가능
                .and()
                    .formLogin() // 로그인에 대한 설정
                        .loginPage("/login") // 로그인 페이지 링크
                        .defaultSuccessUrl("/") // 로그인 성공시 연결되는 주소
                .and()
                    .logout() // 로그아웃 관련 설정
                        .logoutSuccessUrl("/login") // 로그아웃 성공시 연결되는 주소
                        .invalidateHttpSession(true); // 로그아웃시 저장해 둔 세션 날리기
    }

    @Override
    // 로그인 시 필요한 정보를 가져오기
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) // 유저 정보는 userService 에서 가져온다
                .passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코더는 passwordEncoder(BCrypt 사용) 암호화처리
    }

}
