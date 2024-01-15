package com.cooory.ponderpal.post;

import com.cooory.ponderpal.post.dto.PostResDto;
import com.cooory.ponderpal.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/feed-list")
    public String feed(Model model, HttpSession session) {
        List<PostResDto> postList = postService.getPostList();

        model.addAttribute("postList", postList);
        return "/post/feedList";
    }

    @GetMapping("/create-view")
    public String addPost() {

        return "/post/create";
    }
}
