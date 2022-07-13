package com.example.logintest.domain.user;

<<<<<<< HEAD
public interface UserRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email); // 이메일 통해 회원 조회하기 위함

    List<UserInfo> findUserInfoByEmail(String Email);

>>>>>>> a637cb09c61e4237b9c9440155de2991186a7d9d
}
