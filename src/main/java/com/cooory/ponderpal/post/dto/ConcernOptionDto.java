package com.cooory.ponderpal.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConcernOption {
    public List<ConcernData> concernData;

    public static class ConcernData {
        public String concernOptionName;
        public String concernOptionDescription;
    }
}
