package com.cooory.ponderpal.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VoteOptions {

    private String title;
    private String category;
    private String duration;

    private List<Option> concernList;
}
