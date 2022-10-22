package com.example.backend.controller;

import com.example.backend.dao.Marks;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorResponse;
import com.example.backend.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private final MarksService marksService;

    @Autowired
    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }


    @GetMapping
    public ResponseEntity<List<Marks>> getAllMarks() {
        return ResponseEntity.ok(marksService.getAllMarks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMarksById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(marksService.getMarksById(id));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @PostMapping
    public ResponseEntity<?> addMarks(@RequestBody Marks marks) {
//        try {
//            return ResponseEntity.status(201).body(marksService.addMarks(marks.getStudents().getStudentId(), marks.get, marks.getMark()));
//        } catch (CustomException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
//        }
        return null;
    }

    @PutMapping("/{markId}/{studentId}/{subjectId}/{mark}")
    public ResponseEntity<?> updateMarks(@PathVariable Integer markId, @PathVariable Integer studentId, @PathVariable Integer subjectId, @PathVariable Integer mark) {
        try{
            return ResponseEntity.status(204).body(marksService.updateMarks(markId, studentId, subjectId, mark));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @DeleteMapping("/{markId}")
    public ResponseEntity<?> deleteMarks(@PathVariable Integer markId) {
        try {
            marksService.deleteMarks(markId);
            return ResponseEntity.status(204).build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }


}
