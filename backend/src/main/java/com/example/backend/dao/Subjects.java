package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id", nullable = false)
    private Integer subjectId;

    @Column(name="title")
    private String title;

    @OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Marks> marksList;

    @OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SubjectTeacher> subjectTeachers;

}
