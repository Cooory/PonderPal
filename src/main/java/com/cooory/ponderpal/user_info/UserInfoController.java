package com.cooory.ponderpal.user_info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserInfoController {
	
	@GetMapping("/signIn-view")
	public String signInInput() {
		
		return "userInfo/signIn";
	}
	
	@GetMapping("/signUp-view")
	public String signUpInput() {
		
		return "userInfo/signUp";
	}

}
