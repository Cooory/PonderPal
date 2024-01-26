package com.cooory.ponderpal.post.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Data
public class Option {

    private String optionName;
    private String optionDescription;
    private MultipartFile file;

}
