package com.example.backend.service.impl;

import com.example.backend.dao.Students;
import com.example.backend.repository.StudentsRepository;
import com.example.backend.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentsRepository.deleteById(id);
    }

    @Override
    public Students updateStudent(Integer studentId, Students student) {

        Students oldStudentData = studentsRepository.findById(student.getStudentId()).orElseThrow();
        Students newStudentData = Students.builder()
                .studentId(oldStudentData.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();
        return studentsRepository.save(newStudentData);

    }

    @Override
    public Students addStudent(Students student) {
        return studentsRepository.save(student);
    }

    @Override
    public Students getStudentById(Integer id) {
        return studentsRepository.getReferenceById(id);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }
}

