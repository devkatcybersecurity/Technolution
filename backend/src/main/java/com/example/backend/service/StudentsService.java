package com.example.backend.service;

import com.example.backend.dao.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentsService {




    Students updateStudent(Integer studentId, Students student);

    Students addStudent(Students student);

    Students getStudentById(Integer id);

    List<Students> getAllStudents();

    void deleteStudent(Integer id);
}
