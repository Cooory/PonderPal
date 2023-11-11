package com.cooory.ponderpal.post;

import com.cooory.ponderpal.post.dto.ConcernOptionDto;
import com.cooory.ponderpal.post.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostRestController {

    private final PostService postService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public Map<String, String> createPost(@RequestParam("concernName") String concernName,
                                          @RequestParam("concernOption") String concernOption,
                                          @RequestParam("file") List<MultipartFile> files,
                                          HttpServletRequest request,
                                          HttpSession session) throws Exception {
        int userId = (Integer) session.getAttribute("userId");
        ConcernOptionDto concernOptionDto = objectMapper.readValue(concernOption, ConcernOptionDto.class);

		boolean isSuccess = postService.addPost(userId, concernName, concernOptionDto, files);

        Map<String, String> resultMap = new HashMap<>();
        if (isSuccess) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }
}
