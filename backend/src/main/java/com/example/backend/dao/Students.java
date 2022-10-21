package com.example.backend.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "students")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name="student_id", nullable = false)
    private Integer studentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "students", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Marks> marksList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional=false)
    @JoinColumn(name = "group_id", referencedColumnName="group_id")
    @JsonBackReference
    private Groups groups;


}
