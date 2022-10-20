package com.example.backend.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
@Data
public class Groups {

    @Id
    @GeneratedValue
    @Column(name="GROUP_ID", nullable = false)
    private Integer groupId;

    @Column(name="NAME")
    private String name;


}
