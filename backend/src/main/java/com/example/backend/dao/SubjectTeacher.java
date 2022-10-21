package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subject_teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectTeacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="subject_teacher_id", nullable = false)
        private Integer subjectTeacherId;

        @Column(name = "teacher_id")
        private int teacherId;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "group_id")
        @JsonBackReference
        private Groups groups;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "subject_id")
        @JsonBackReference
        private Subjects subjects;


}
