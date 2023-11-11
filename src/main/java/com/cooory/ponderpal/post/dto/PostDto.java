package com.cooory.ponderpal.post.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private int id;

    private String title;

    private int voteDuration;

    private int voteHashtag;

    private int likeCount;

    private int dislikeCount;

    private Date createdAt;

    private Date updatedAt;

    private List<VoteOptionDto> VoteOptions;

}
