package com.cooory.ponderpal.user_info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooory.ponderpal.user_info.domain.UserInfo;
import com.cooory.ponderpal.user_info.service.UserInfoService;

// Class for API
@RestController // @Controller + @ResponseBody
@RequestMapping("/user")
public class UserInfoRestController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/signUp")
	public Map<String, String> signUp(
			@RequestParam("email") String email
			, @RequestParam("password") String password
			, @RequestParam("fullName") String fullName
			, @RequestParam("userName") String userName
			, @RequestParam("contactNumber") String contactNumber
			, @RequestParam("gender") String gender
			, @RequestParam("birth") String birth
			, @RequestParam("introduction") String introduction) {
		
			
		UserInfo userInfo = userInfoService.addUser(email, password, fullName, userName, contactNumber, gender, birth, introduction);
		
		Map<String, String> resultMap = new HashMap<>();
		if(userInfo != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}
