package com.example.backend.service;

import com.example.backend.dao.SubjectTeacher;
import com.example.backend.dao.Subjects;

import java.util.List;

public interface SubjectsService {


    List<Subjects> getAllSubjects();

    Subjects getSubjectById(Integer subjectId);

    Subjects addSubject(String subjectName);

    List<SubjectTeacher> getMarksForParticularSubject(int subjectId);

    Subjects updateSubject(Integer subjectId, Subjects subject);

    void deleteSubject(Integer subjectId);
}
