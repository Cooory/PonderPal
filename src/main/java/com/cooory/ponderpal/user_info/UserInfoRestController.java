package com.cooory.ponderpal.user_info;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/duplicateNewPassword")
	public Map<String, Boolean> duplicateNewPassword(@RequestParam("password") String password) {
		
		boolean isDuplicate = userInfoService.isDuplicateNewPassword(password);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
		
	}
	
	@PostMapping("/signIn")
	public Map<String, String> signIn(
		@RequestParam("email") String email
		, @RequestParam("password") String password
		, HttpServletRequest request) {
		
		UserInfo userInfo = userInfoService.getUser(email, password);
		
		Map<String, String> resultMap = new HashMap<>();
		if(userInfo != null) {
			
			// 로그인 성공
			HttpSession session = request.getSession();
			// 세션에 로그인이 되었다 라는 정보를 저장
			// 세션에 사용자와 관련된 정보를 저장
			// 세션에 사용자 정보가 저장된 경우 로그인된 상태로 파악
			session.setAttribute("userId", userInfo.getId());
			session.setAttribute("userFullName", userInfo.getFullName());
			
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/duplicateId")
	public Map<String, Boolean> duplicateId(@RequestParam("email") String email) {
		
		boolean isDuplicate = userInfoService.isDuplicateId(email);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
		
	}
	
	
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
