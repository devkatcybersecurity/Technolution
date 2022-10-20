package com.example.backend.controller;

import com.example.backend.dao.Subjects;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorResponse;
import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @GetMapping
    public ResponseEntity<List<Subjects>> getAllSubjects() {
        return ResponseEntity.ok(subjectsService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(subjectsService.getSubjectById(id));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getApiError(), e.getErrorMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> addSubject(@RequestBody Subjects subject) {
        try {
            return ResponseEntity.status(201).body(subjectsService.addSubject(subject.getTitle()));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getApiError(), e.getErrorMessage()));
        }
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<?> updateSubject(@PathVariable Integer subjectId, @RequestBody Subjects subject) {
        try {
            return ResponseEntity.status(204).body(subjectsService.updateSubject(subjectId, subject));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getApiError(), e.getErrorMessage()));
        }
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer subjectId) {
        try {
            subjectsService.deleteSubject(subjectId);
            return ResponseEntity.status(204).build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getApiError(), e.getErrorMessage()));
        }
    }



}
