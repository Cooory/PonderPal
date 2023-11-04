package com.cooory.ponderpal.user_info.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "user_info")
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "userName")
    private String userName;

    @Column(name = "contactNumber")
    private String contactNumber;

    private String gender;
    private String birth;
    private String introduction;

    @UpdateTimestamp
    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;

}
