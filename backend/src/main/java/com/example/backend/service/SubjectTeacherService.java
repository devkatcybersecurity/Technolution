package com.example.backend.service;

import com.example.backend.dao.SubjectTeacher;

import java.util.List;

public interface SubjectTeacherService {
    long noOfStudentsFromTeacherId(int teacherId);

    List<SubjectTeacher> findAll();

    SubjectTeacher getSubjectTeacherById(Integer subjectTeacherId);

    SubjectTeacher addSubjectTeacher(Integer subjectId, Integer teacherId, Integer groupId);

    void deleteSubjectTeacher(Integer subjectTeacherId);
}
