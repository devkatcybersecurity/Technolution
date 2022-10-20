package com.example.backend.service.impl;

import com.example.backend.repository.SubjectsRepository;
import com.example.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectTeacherServiceImpl implements SubjectTeacherService {


    private final SubjectsRepository subjectTeacherRepository;


    @Autowired
    public SubjectTeacherServiceImpl(SubjectsRepository subjectTeacherRepository) {
        this.subjectTeacherRepository = subjectTeacherRepository;
    }
}

