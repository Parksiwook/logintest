package com.example.logintest.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email); // 회원 조회

}
