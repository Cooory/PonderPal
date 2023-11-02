package com.cooory.ponderpal.post.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteOptions {
	
	private String title;
	private String category;
	private String duration;

	private List<Option> concernList;
}
