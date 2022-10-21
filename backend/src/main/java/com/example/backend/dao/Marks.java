package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "marks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marks {

    @Id
    @GeneratedValue
    @Column(name="mark_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer markId;

    @Column(name="date_time")
    private Date dateTime;

    @Column(name="marks")
    private Integer marks;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    @JsonBackReference
    private Students students;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    @JsonBackReference
    private Subjects subjects;




}
