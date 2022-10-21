package com.example.backend.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.*;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "marks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "markId")
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
    @JoinColumn(name = "student_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Students students;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Subjects subjects;




}
