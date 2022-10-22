package com.example.backend.controller;

import com.example.backend.dao.SubjectTeacher;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorResponse;
import com.example.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-teacher")
public class SubjectTeacherController {

    private final SubjectTeacherService subjectTeacherService;

    @Autowired
    public SubjectTeacherController(SubjectTeacherService subjectTeacherService) {
        this.subjectTeacherService = subjectTeacherService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectTeacher>> getAllSubjectTeacher() {
        return ResponseEntity.ok(subjectTeacherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectTeacherById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(subjectTeacherService.getSubjectTeacherById(id));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new CustomException(e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

//    @PostMapping
//    public ResponseEntity<?> addSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
//        try {
//            return ResponseEntity.status(201).body(subjectTeacherService.addSubjectTeacher(subjectTeacher));
//        } catch (CustomException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorResponse( e.getApiError(), e.getErrorMessage() ) );
//        }
//    }
}
