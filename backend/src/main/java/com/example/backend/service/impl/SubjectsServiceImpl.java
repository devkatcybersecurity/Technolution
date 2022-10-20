package com.example.backend.service.impl;

import com.example.backend.repository.SubjectsRepository;
import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    private final SubjectsRepository subjectsRepository;


    @Autowired
    public SubjectsServiceImpl(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }
}

