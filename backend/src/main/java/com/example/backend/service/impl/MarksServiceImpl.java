package com.example.backend.service.impl;

import com.example.backend.repository.MarksRepository;
import com.example.backend.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;


    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }
}

