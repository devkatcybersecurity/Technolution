package com.example.backend.service;

import com.example.backend.dao.Marks;

import java.util.List;

public interface MarksService {

    List<Marks> getAllMarks();
    Marks addMarks(Integer studentId, Integer subjectId, Integer mark);
    Marks updateMarks(Integer markId, Integer studentId, Integer subjectId, Integer mark);
    void deleteMarks(Integer markId);

    long getMarks(int studentsId);

    Marks getMarksById(Integer markId);

}
