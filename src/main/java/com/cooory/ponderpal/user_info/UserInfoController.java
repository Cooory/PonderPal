package com.cooory.ponderpal.user_info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserInfoController {
	
	@GetMapping("/changePassword")
	public String changePassword() {
		
		return "userInfo/changePassword";
	}
	
	@GetMapping("/signIn-view")
	public String signInInput() {
		
		return "userInfo/signIn";
	}
	
	@GetMapping("/signUp-view")
	public String signUpInput() {
		
		return "userInfo/signUp";
	}
	
	@GetMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userFullName");
		
		return "redirect:/user/signIn-view";
	}

}
