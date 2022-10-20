package com.example.backend.controller;

import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }
}
