package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Groups {

    @Id
    @GeneratedValue
    @Column(name="GROUP_ID", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer groupId;

    @Column(name="NAME")
    private String name;



}
