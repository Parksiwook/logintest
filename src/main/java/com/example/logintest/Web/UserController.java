package com.example.logintest.Web;

import com.example.logintest.service.UserService;
import com.example.logintest.Web.dto.UserinfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/user") // signup api
    public String signup(UserinfoDto infoDto) {
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping("/logout") // logout by GET 요청
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder
                .getContext().getAuthentication());
        return "redirect:/login";
    }

}
