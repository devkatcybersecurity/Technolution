package com.example.backend.controller;

import com.example.backend.dao.Students;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorResponse;
import com.example.backend.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {

        return ResponseEntity.ok(studentsService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(studentsService.getStudentById(id));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getErrorCode(), e.getErrorMessage()));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Students student) {
        return ResponseEntity.status(201).body(studentsService.addStudent(student));
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @RequestBody Students student) {
        return ResponseEntity.status(204).body(studentsService.updateStudent(studentId, student));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
        studentsService.deleteStudent(studentId);
        return ResponseEntity.status(204).build();
    }


}
