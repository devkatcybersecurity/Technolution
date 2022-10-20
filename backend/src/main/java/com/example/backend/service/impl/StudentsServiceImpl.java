package com.example.backend.service.impl;

import com.example.backend.dao.Students;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorCode;
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
        Students oldStudentData = studentsRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.STUDENT_NOT_FOUND.getErrorCode(), ErrorCode.STUDENT_NOT_FOUND.getErrorMessage()));
        studentsRepository.deleteById(id);
    }

    @Override
    public Students updateStudent(Integer studentId, Students student) {


        Students oldStudentData = studentsRepository.findById(studentId).orElseThrow(
                () -> new CustomException(ErrorCode.STUDENT_NOT_FOUND.getErrorCode(), ErrorCode.STUDENT_NOT_FOUND.getErrorMessage()));
            Students newStudentData = Students.builder()
                    .studentId(studentId)
                    .firstName(student.getFirstName() != null ? student.getFirstName() : oldStudentData.getFirstName())
                    .lastName(student.getLastName() != null ? student.getLastName() : oldStudentData.getLastName())
                    .groupId(student.getGroupId() != null ? student.getGroupId() : oldStudentData.getGroupId())
                    .build();
            return studentsRepository.save(newStudentData);



    }

    @Override
    public Students addStudent(Students student) {
        return studentsRepository.save(student);
    }

    @Override
    public Students getStudentById(Integer id) {
        Students students = studentsRepository.findById(id).orElseThrow(
                () -> new CustomException( ErrorCode.STUDENT_NOT_FOUND.getErrorCode(), ErrorCode.STUDENT_NOT_FOUND.getErrorMessage()));
        return students;
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }
}

