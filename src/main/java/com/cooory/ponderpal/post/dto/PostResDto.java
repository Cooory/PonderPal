package com.cooory.ponderpal.post.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResDto {
    private long id;

    private String title;

    private String creator;

    private int voteDuration;

    private String voteCategory;

    private String content;

    private int likeCount;

    private int dislikeCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<VoteOptionResDto> voteOptions;

}
