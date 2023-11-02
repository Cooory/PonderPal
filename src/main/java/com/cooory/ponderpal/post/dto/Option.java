package com.cooory.ponderpal.post.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Option {
	
	private String optionName;
	private String optionDiscription;
 	private MultipartFile file;

}
