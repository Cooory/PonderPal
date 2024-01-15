package com.cooory.ponderpal.post.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cooory.ponderpal.common.FileManager;
import com.cooory.ponderpal.post.domain.Post;
import com.cooory.ponderpal.post.domain.VoteOption;
import com.cooory.ponderpal.post.dto.VoteOptionReqDto;
import com.cooory.ponderpal.post.dto.VoteOptionDataReqDto;
import com.cooory.ponderpal.post.dto.PostResDto;
import com.cooory.ponderpal.post.repository.PostRepository;
import com.cooory.ponderpal.post.repository.VoteOptionRepository;
import com.cooory.ponderpal.post.dto.VoteOptionResDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final VoteOptionRepository voteOptionRepository;

    @Transactional(readOnly = true)
    public PostResDto getPost(long postId) {
        Optional<Post> postOpt = postRepository.findById(postId);
        if(postOpt.isEmpty()) {
            return null;
        }
        Post post = postOpt.get();

        PostResDto postDto = new PostResDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setCreator(post.getCreator());
        postDto.setVoteDuration(post.getVoteDuration());
        postDto.setVoteCategory(post.getVoteCategory());
        postDto.setContent(post.getContent());
        postDto.setLikeCount(post.getLikeCount());
        postDto.setDislikeCount(post.getDislikeCount());
        postDto.setVoteOptions(new ArrayList<>());


        List<VoteOption> voteOptions = voteOptionRepository.findAllByPostIdEquals(post.getId());
        for(int i = 0; i < voteOptions.size(); i++) {
            VoteOption voteOption = voteOptions.get(i);

            VoteOptionResDto voteOptionDto = new VoteOptionResDto();
            voteOptionDto.setPostId(voteOption.getPostId());
            voteOptionDto.setVoteOptionName(voteOption.getVoteOptionName());
            voteOptionDto.setVoteOptionDescription(voteOption.getVoteOptionDescription());
            voteOptionDto.setVoteOptionCategory(voteOption.getVoteOptionCategory());
            voteOptionDto.setImagePath(voteOption.getImagePath());

            List<VoteOptionResDto> voteOptionDtos = postDto.getVoteOptions();
            voteOptionDtos.add(voteOptionDto);
        }
        return postDto;
    }

    @Transactional
    public boolean addPost(int userId, String postName, VoteOptionDataReqDto voteOptionDataReqDto, List<MultipartFile> files, String userName) {
        Post post = new Post();
        post.setTitle(postName); // unify names
        //post.setVoteDuration(post.getVoteDuration());
        //post.setVoteHashtag(post.getVoteHashtag());
        //post.setLikeCount(post.getLikeCount());
        //post.setDislikeCount(post.getDislikeCount());
        post.setCreator(userName);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        final Post insertedPost = postRepository.save(post); // Doesn't have to get return.

        for(int i = 0; i < voteOptionDataReqDto.getVoteOptions().size(); i++) {
            String imagePath = FileManager.saveFile(userId, files.get(i));

            VoteOptionReqDto dto = voteOptionDataReqDto.getVoteOptions().get(i);
            VoteOption voteOption = new VoteOption();
            voteOption.setPostId(insertedPost.getId());
            voteOption.setVoteOptionName(dto.getVoteOptionName());
            voteOption.setVoteOptionDescription(dto.getVoteOptionDescription());
            voteOption.setImagePath(imagePath);
            voteOption.setCreatedAt(LocalDateTime.now());
            voteOption.setUpdatedAt(LocalDateTime.now());

            voteOptionRepository.save(voteOption);
        }

        return true;
    }

    public List<PostResDto> getPostList() {
        // postRepository.findAllWithVoteOptions();  // Have to bring Joined results. But JPA oneToMany relation is needed.
        List<PostResDto> postDtoList = new ArrayList<>();

        List<Post> postList = postRepository.findAll();

        for(Post post : postList) {
            PostResDto postDto = new PostResDto();
            BeanUtils.copyProperties(post, postDto);

            List<VoteOptionResDto> voteOptionDtos = new ArrayList<>();

            List<VoteOption> voteOptionList = voteOptionRepository.findAllByPostIdEquals(post.getId());
            for(VoteOption voteOption : voteOptionList) {
                VoteOptionResDto voteOptionDto = new VoteOptionResDto();
                BeanUtils.copyProperties(voteOption, voteOptionDto);
                voteOptionDtos.add(voteOptionDto);
            }

            postDto.setVoteOptions(voteOptionDtos);
            postDtoList.add(postDto);
        }

        return postDtoList;
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
