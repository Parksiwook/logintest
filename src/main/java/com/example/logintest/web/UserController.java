package com.example.logintest.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller

public class UserController {
    private  final UserService userService;
}
