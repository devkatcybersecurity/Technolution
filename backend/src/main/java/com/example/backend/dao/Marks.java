package com.example.backend.dao;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MARKS")
@Data
public class Marks {

    @Id
    @GeneratedValue
    @Column(name="MARK_ID", nullable = false)
    private Integer markId;

    @Column(name="STUDENT_ID")
    private Integer studentId;

    @Column(name="SUBJECT_ID")
    private Integer subjectId;

    @Column(name="DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="MARK")
    private Integer mark;

    @ManyToOne
    private Subjects subjects;
}
