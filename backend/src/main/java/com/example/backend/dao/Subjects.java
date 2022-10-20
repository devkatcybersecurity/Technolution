package com.example.backend.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SUBJECT_ID", nullable = false)
    private Integer subjectId;

    @Column(name="TITLE")
    private String title;

}
