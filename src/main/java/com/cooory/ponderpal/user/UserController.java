package com.cooory.ponderpal.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/changePassword")
    public String changePassword() {

        return "user/changePassword";
    }

    @GetMapping("/signIn-view")
    public String signInInput() {

        return "user/signIn";
    }

    @GetMapping("/signUp-view")
    public String signUpInput() {

        return "user/signUp";
    }

    @GetMapping("/signOut")
    public String signOut(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userFullName");

        return "redirect:/user/signIn-view";
    }

}
