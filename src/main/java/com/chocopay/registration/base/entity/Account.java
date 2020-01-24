package com.chocopay.registration.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CHOCO_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "CHOCO_ACCOUNT_SEQ")
    @SequenceGenerator(name = "CHOCO_ACCOUNT_SEQ", sequenceName = "CHOCO_ACCOUNT_SEQ")
    @Column(name = "CA_PK_ID", length = 11)
    private Long id;

    @Column(name = "ACC_NUM", length = 500)
    private String accNumber;

    @Column(name = "MOBILE", length = 15)
    private String bankName;

    @Column(name = "EMAIL")
    private String ifscCode;

    @Column(name = "ACC_NAME", length = 15)
    private String accName;

    @Column(name = "BUSINESS_ID")
    private Integer businessId;

}
