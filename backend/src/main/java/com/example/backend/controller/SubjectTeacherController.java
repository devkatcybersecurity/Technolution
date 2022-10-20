package com.example.backend.controller;

import com.example.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject-teacher")
public class SubjectTeacherController {

    private final SubjectTeacherService subjectTeacherService;

    @Autowired
    public SubjectTeacherController(SubjectTeacherService subjectTeacherService) {
        this.subjectTeacherService = subjectTeacherService;
    }

}
