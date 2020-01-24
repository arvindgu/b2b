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
@Table(name = "CHOCO_GROUP")
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "CHOCO_GROUP_SEQ")
    @SequenceGenerator(name = "CHOCO_GROUP_SEQ", sequenceName = "CHOCO_GROUP_SEQ")
    @Column(name = "CG_PK_ID", length = 11)
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "groupId")
    @Fetch(FetchMode.SELECT)
    private List<User> users  = new ArrayList<>();

}
