package com.cooory.ponderpal.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

	@GetMapping("/feed-view")
	public String feed() {
		
		return "/post/feed";
	}
	
	@GetMapping("/create-view")
	public String addPost() {
		
		return "/post/create";
	}
}
