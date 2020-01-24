package com.chocopay.registration.base.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CHOCO_USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "CHOCO_USER_SEQ")
    @SequenceGenerator(name = "CHOCO_USER_SEQ", sequenceName = "CHOCO_USER_SEQ")
    @Column(name = "CU_PK_ID", length = 11)
    private Long id;

    @Column(name = "BUSINESS_ID")
    private Integer businessId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USR_TOKEN")
    private String token;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "GROUP_ID")
    private Integer groupId;
}
