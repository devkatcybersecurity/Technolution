package com.example.backend.controller;

import com.example.backend.dao.Students;
import com.example.backend.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentsService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentsService.getStudentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Students> addStudent(@RequestBody Students student) {
        return ResponseEntity.ok(studentsService.addStudent(student));
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<Students> updateStudent(@PathVariable Integer studentId, @RequestBody Students student) {

        return ResponseEntity.ok(studentsService.updateStudent(studentId, student));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
        studentsService.deleteStudent(studentId);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
