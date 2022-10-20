package com.example.backend.service;

import com.example.backend.dao.Students;

import java.util.List;

public interface StudentsService {




    Students updateStudent(Integer studentId, Students student);

    Students addStudent(Students student);

    Students getStudentById(Integer id);

    List<Students> getAllStudents();

    void deleteStudent(Integer id);
}
