package com.cooory.ponderpal.post.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class VoteOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "postId")
    private int postId;

    @Column(name = "concernOptionName")
    private String concernOptionName;

    @Column(name = "concernOptionDescription")
    private String concernOptionDescription;

    @Column(name = "filePath")
    private String filePath;

    @UpdateTimestamp
    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;

}
