package com.example.backend.dao;

import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "STUDENTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue
    @Column(name="STUDENT_ID", nullable = false)
    private Integer studentId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="GROUP_ID")
    private Integer groupId;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "STUDENT_ID")
//    private List<Marks> marksList;
//
//    @ManyToOne
//    @JoinColumn(name = "GROUP_ID", insertable = false, updatable = false)
//    private Group group;


}
