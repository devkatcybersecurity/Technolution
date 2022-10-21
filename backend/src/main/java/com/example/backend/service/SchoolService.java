package com.example.backend.service;

import com.example.backend.models.MarksBySubjectModel;

import java.util.List;

public interface SchoolService {
    long getStudentMarks(int studentId);

    long getCountStudentsWithTeacherId(int teacherId);

    List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId);
}
