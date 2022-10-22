package com.example.backend.service.impl;

import com.example.backend.dao.Marks;
import com.example.backend.dao.SubjectTeacher;
import com.example.backend.models.MarksBySubjectModel;
import com.example.backend.models.MarksListModel;
import com.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private MarksService marksService;
    private SubjectsService subjectsService;
    private SubjectTeacherService subjectTeacherService;

    private StudentsService studentsService;

    @Autowired
    public SchoolServiceImpl(MarksService marksService,
                             SubjectsService subjectsService,
                             SubjectTeacherService subjectTeacherService,
                             StudentsService studentsService) {
        this.marksService = marksService;
        this.subjectsService = subjectsService;
        this.subjectTeacherService = subjectTeacherService;
        this.studentsService = studentsService;
    }

    @Override
    public long getStudentMarks(int studentId) {
        // TODO Auto-generated method stub
        return marksService.getMarks(studentId);
    }

    @Override
    public long getCountStudentsWithTeacherId(int teacherId) {
        // TODO Auto-generated method stub
        return subjectTeacherService.noOfStudentsFromTeacherId(teacherId);
    }
    @Override
    public List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId) {
        // TODO Auto-generated method stub
        List<Marks> marksList = studentsService.getStudentById(studentsId).getMarksList();
        List<MarksBySubjectModel> marksBySubjectModels = new ArrayList<>();

        if(marksList != null) {
            for(Marks marks : marksList) {
                MarksBySubjectModel marksBySubjectModel = new MarksBySubjectModel();
                marksBySubjectModel.setSubjectName(marks.getSubjects().getTitle());

                List<MarksListModel> marksListModels = new ArrayList<>();
                    MarksListModel marksListModel = new MarksListModel();
                    marksListModel.setMarks(marks.getMarks());
                    marksListModel.setDate(marks.getDateTime());
                    marksListModels.add(marksListModel);
                marksBySubjectModel.setMarksListModels(marksListModels);
                marksBySubjectModels.add(marksBySubjectModel);
            }
        }
        return marksBySubjectModels;
    }

}

