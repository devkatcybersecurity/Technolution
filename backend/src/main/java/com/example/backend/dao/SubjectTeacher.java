package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subject_teacher")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "subjectTeacherId")
public class SubjectTeacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="subject_teacher_id", nullable = false)
        private Integer subjectTeacherId;

        @Column(name = "teacher_id")
        private int teacherId;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "group_id")
        @JsonIdentityReference(alwaysAsId = true)
        private Groups groups;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "subject_id")
        @JsonIdentityReference(alwaysAsId = true)
        private Subjects subjects;


}
