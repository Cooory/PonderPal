package com.cooory.ponderpal.post.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(name = "voteOption")
    private int voteOption;

    @Column(name = "voteDuration")
    private int voteDuration;

    @Column(name = "voteHashtag")
    private int voteHashtag;

    @Column(name = "likeCount")
    private int likeCount;

    @Column(name = "dislikeCount")
    private int dislikeCount;

    @UpdateTimestamp
    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;

}
