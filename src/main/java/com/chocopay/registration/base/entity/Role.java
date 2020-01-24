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
@Table(name = "CHOCO_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "CHOCO_ROLE_SEQ")
    @SequenceGenerator(name = "CHOCO_ROLE_SEQ", sequenceName = "CHOCO_ROLE_SEQ")
    @Column(name = "CR_PK_ID", length = 11)
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "roleId")
    @Fetch(FetchMode.SELECT)
    private List<User> users  = new ArrayList<>();

}
