package com.cooory.ponderpal.post.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VoteOptionResDto {

    private long id;

    private long postId;

    private String voteOptionName;

    private String voteOptionDescription;

    private String voteOptionCategory;

    private String imagePath;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
