package com.cooory.ponderpal.post.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteOptionDto {

    private int postId;

    private String concernOptionName;

    private String concernOptionDescription ;

    private String filePath;

}
