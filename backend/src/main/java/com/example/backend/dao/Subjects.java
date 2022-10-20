package com.example.backend.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "SUBJECTS")
@Data
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SUBJECT_ID", nullable = false)
    private Integer subjectId;

    @Column(name="TITLE")
    private String title;





}
