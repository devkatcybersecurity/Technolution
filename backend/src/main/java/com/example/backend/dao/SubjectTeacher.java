package com.example.backend.dao;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "SUBJECT_TEACHER")
@Data
public class SubjectTeacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID", nullable = false)
        private Integer id;

        @Column(name="SUBJECT_ID")
        private Integer subjectId;

        @Column(name = "TEACHER_ID")
        private Integer teacherId;

        @Column(name = "GROUP_ID")
        private Integer groupId;
}
