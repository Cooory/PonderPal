package com.cooory.ponderpal.post.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cooory.ponderpal.common.FileManager;
import com.cooory.ponderpal.post.domain.Post;
import com.cooory.ponderpal.post.domain.VoteOption;
import com.cooory.ponderpal.post.dto.ConcernDataDto;
import com.cooory.ponderpal.post.dto.ConcernOptionDto;
import com.cooory.ponderpal.post.dto.PostDto;
import com.cooory.ponderpal.post.dto.VoteOptionDto;
import com.cooory.ponderpal.post.repository.PostRepository;
import com.cooory.ponderpal.post.repository.VoteOptionRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final VoteOptionRepository voteOptionRepository;

    @Transactional(readOnly = true)
    public PostDto getPost(int postId) {
        Optional<Post> postOpt = postRepository.findById(postId);
        if(postOpt.isEmpty()) {
            return null;
        }
        Post post = postOpt.get();

        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setVoteDuration(post.getVoteDuration());
        postDto.setVoteHashtag(post.getVoteHashtag());
        postDto.setLikeCount(post.getLikeCount());
        postDto.setDislikeCount(post.getDislikeCount());
        postDto.setVoteOptions(new ArrayList<>());

        // 유지 보수 설계 힘드니까


        List<VoteOption> voteOptions = voteOptionRepository.findAllByPostIdEquals(post.getId());
        for(int i = 0; i < voteOptions.size(); i++) {
            VoteOption voteOption = voteOptions.get(i);

            VoteOptionDto voteOptionDto = new VoteOptionDto();
            voteOptionDto.setPostId(voteOption.getPostId());
            voteOptionDto.setConcernOptionName(voteOption.getConcernOptionName());
            voteOptionDto.setConcernOptionDescription(voteOption.getConcernOptionDescription());
            voteOptionDto.setFilePath(voteOption.getFilePath());

            List<VoteOptionDto> voteOptionDtos = postDto.getVoteOptions();
            voteOptionDtos.add(voteOptionDto);
        }
        return postDto;
    }

    @Transactional
    public boolean addPost(int userId, String concernName, ConcernOptionDto concernOptions, List<MultipartFile> files) {
        Post post = new Post();
        post.setTitle(concernName); // 이름 통일
        //post.setVoteDuration(post.getVoteDuration());
        //post.setVoteHashtag(post.getVoteHashtag());
        //post.setLikeCount(post.getLikeCount());
        //post.setDislikeCount(post.getDislikeCount());
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());

        final Post insertedPost = postRepository.save(post); // return 안받아도 되긴 함. 어차피 post 갱신 되긴 함.

        for(int i = 0; i < concernOptions.getConcernData().size(); i++) {
            String filePath = FileManager.saveFile(userId, files.get(i));

            ConcernDataDto dto = concernOptions.getConcernData().get(i);
            VoteOption voteOption = new VoteOption();
            voteOption.setPostId(insertedPost.getId());
            voteOption.setConcernOptionName(dto.getConcernOptionName());
            voteOption.setConcernOptionDescription(dto.getConcernOptionDescription());
            voteOption.setFilePath(filePath);
            voteOption.setCreatedAt(new Date());
            voteOption.setUpdatedAt(new Date());

            voteOptionRepository.save(voteOption);
        }

        return true;
    }

//	public int addPost(int userId, String title, String optionName, String optionDiscription, String voteCategory, MultipartFile file) {  //순서가 맞으면 됨
//		
//		String imagePath = FileManager.saveFile(userId, file);
//		
//		return ;
//		
//	}
//
//	
//	
}
