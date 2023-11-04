package com.cooory.ponderpal.post.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class Option {

    private String optionName;
    private String optionDiscription;
    private MultipartFile file;

}
