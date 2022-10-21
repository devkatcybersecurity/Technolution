package com.example.backend.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "groupId")
public class Groups {

    @Id
    @GeneratedValue
    @Column(name="group_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer groupId;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groups", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Students> studentsList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groups", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIdentityReference(alwaysAsId = true)
    private List<SubjectTeacher> subjectTeachersList;



}
