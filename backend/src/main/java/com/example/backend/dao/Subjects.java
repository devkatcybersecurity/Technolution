package com.example.backend.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "subjectId")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id", nullable = false)
    private Integer subjectId;

    @Column(name="title")
    private String title;

    @OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Marks> marksList;

    @OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<SubjectTeacher> subjectTeachers;

}
