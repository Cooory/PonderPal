package com.cooory.ponderpal.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooory.ponderpal.post.dto.VoteOptions;
import com.cooory.ponderpal.post.service.PostService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	

	@PostMapping("/create")
	public Map<String, String> createPost(
//			@RequestParam("title") String title
//			, @RequestParam("optionName") String optionName
//			, @RequestParam("optionDiscription") String optionDiscription
//			, @RequestParam("voteCategory") String voteCategory
//			, @RequestParam("imagePath") String imagePath
			VoteOptions voteOptions
			, HttpSession session) {
		
		int email = (Integer)session.getAttribute("userId");
		
//		int count = postService.addPost(email, title, optionName, optionDiscription, voteCategory);
		
		int count = 0;
		
		Map<String, String> resultMap = new HashMap<>();	
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}
