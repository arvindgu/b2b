package com.chocopay.registration.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CHOCO_BUSINESS")
public class Business {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "CHOCO_BUSINESS_SEQ")
    @SequenceGenerator(name = "CHOCO_BUSINESS_SEQ", sequenceName = "CHOCO_BUSINESS_SEQ")
    @Column(name = "CB_PK_ID", length = 11)
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "MOBILE", length = 15)
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LANDLINE", length = 15)
    private String landLine;

    @Column(name = "GSTIN", length = 20)
    private String gstin;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "BUSINESS_ID")
    @Fetch(FetchMode.SELECT)
    private List<User> users  = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "BUSINESS_ID")
    @Fetch(FetchMode.SELECT)
    private List<Account> accountList  = new ArrayList<>();

}
