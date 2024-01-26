package com.cooory.ponderpal.post.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class VoteOptionDataReqDto {
    private List<VoteOptionReqDto> voteOptions;

}
