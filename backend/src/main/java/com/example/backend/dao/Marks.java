package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MARKS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marks {

    @Id
    @GeneratedValue
    @Column(name="MARK_ID", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer markId;

    @Column(name="STUDENT_ID")
    private Integer studentId;

    @Column(name="SUBJECT_ID")
    private Integer subjectId;

    @Column(name="DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date date;

    @Column(name="MARK")
    private Integer mark;

//    @ManyToOne
//    private Subjects subjects;
}
