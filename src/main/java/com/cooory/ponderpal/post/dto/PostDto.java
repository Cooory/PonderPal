package com.cooory.ponderpal.post.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PostDto {
    private int id;

    private String title;

    private int voteOptionCount;

    private int voteDuration;

    private int voteHashtag;

    private int likeCount;

    private int dislikeCount;

    private Date createdAt;

    private Date updatedAt;
}
